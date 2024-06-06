import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PrimeNumberGameGUI extends JFrame {

    private JLabel numberLabel;
    private JButton trueButton;
    private JButton falseButton;
    private JButton startButton;
    private JLabel resultLabel;
    private JLabel timerLabel; // ストップウォッチ用のラベル

    private Random random;
    private int randomNumber;
    private Timer timer;
    private double secondsPassed; // 経過秒数

    public PrimeNumberGameGUI() {
        setTitle("素数あてゲーム");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500); // ウィンドウサイズを大きくする
        setLocationRelativeTo(null);
        setLayout(new BorderLayout()); // レイアウトマネージャーをBorderLayoutに変更
        

        // 上部パネルの初期化
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        numberLabel = new JLabel();
        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(100, 50)); // 幅100ピクセル、高さ50ピクセル
        topPanel.add(numberLabel);
        topPanel.add(startButton);
        add(topPanel, BorderLayout.NORTH); // 上部パネルを追加
    

        // ストップウォッチラベルの初期化
        timerLabel = new JLabel("Time: 0.00 seconds");
        add(timerLabel, BorderLayout.WEST); // ストップウォッチラベルを追加

        // 中央パネルの初期化
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        trueButton = new JButton("True");
        trueButton.setPreferredSize(new Dimension(250, 100));
        trueButton.setFont(new Font("Arial",Font.PLAIN,30));
        falseButton = new JButton("False");
        falseButton.setPreferredSize(new Dimension(250, 100));
        falseButton.setFont(new Font("Arial",Font.PLAIN,30));
        centerPanel.add(new JLabel("True or False "));
        centerPanel.add(trueButton);
        centerPanel.add(falseButton);
        add(centerPanel, BorderLayout.CENTER); // 中央パネルを追加
        


        // 下部パネルの初期化
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultLabel = new JLabel();
        bottomPanel.add(resultLabel);
        add(bottomPanel, BorderLayout.SOUTH); // 下部パネルを追加
       
        random = new Random();
        timer = new Timer(10, new ActionListener() { // 10ミリ秒ごとに更新
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsPassed += 0.01;
                timerLabel.setText("Time: " + String.format("%.2f", secondsPassed) + " seconds");
            }
        });

        // Startボタンのアクションリスナー
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 新しいランダムな数を生成して表示し、TrueとFalseボタンを有効化する
                generateRandomNumber();
                trueButton.setEnabled(true);
                falseButton.setEnabled(true);
                // ストップウォッチのリセットと開始
                secondsPassed = 0;
                timerLabel.setText("Time: 0.00 seconds");
                timer.start();
            }
        });

        // Trueボタンのアクションリスナー
        trueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Trueボタンが押されたときの処理を実行
                handleGuess(true);
            }
        });

        // Falseボタンのアクションリスナー
        falseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Falseボタンが押されたときの処理を実行
                handleGuess(false);
            }
        });

        // TrueとFalseボタンを無効化する
        trueButton.setEnabled(false);
        falseButton.setEnabled(false);
    }

    // 新しいランダムな数を生成して表示するメソッド
    private void generateRandomNumber() {
        randomNumber = 10 + random.nextInt(91); // 10から100の間のランダムな数を生成
        numberLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        numberLabel.setText(Integer.toString(randomNumber));
    }

    // ユーザーの回答を処理するメソッド
    private void handleGuess(boolean guessedPrime) {
        boolean isPrime = isPrime(randomNumber);
        // ユーザーの回答が正しいかどうかを判断して、結果を表示する
        if (guessedPrime == isPrime) {
            resultLabel.setText("正解");
            numberLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        } else {
            resultLabel.setText("不正解");
            numberLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        }
        // アニメーションを開始する
        timer.stop();
        //二回目から押せなくなる
        trueButton.setEnabled(false);
        falseButton.setEnabled(false);

    }

    // 素数かどうかを判定するメソッド
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
