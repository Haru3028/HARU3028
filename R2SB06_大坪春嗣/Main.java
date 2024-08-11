import java.util.Random;
import java.util.Scanner;

/*
 * メインクラス　Mainは、死神の名前をユーザから所得
 * 縛道と破道はランダムで番号、受け取った名前とともに生成
 * 
 * @H.Otubo
 * @I.Awa (レビュア)
 */
public class Main {

    public static void main(String[] args) {

        /*
         * ユーザから死神の名前を取得し
         * 破道または縛道をランダムに使用する死神を生成し表示します
         * 
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("死神の名前を入力してください: ");
        String chosenName = scanner.nextLine();  // ユーザーからの名前の入力を取得

        Random random = new Random();
        Shinigami shinigami;

        // ランダムに破道か縛道を生成
        if (random.nextBoolean()) {
            shinigami = new Hado(chosenName);
        } else {
            shinigami = new Bakudo(chosenName);
        }

        // 使用する呪文を表示
        shinigami.useSpell();

        scanner.close();  // Scannerを閉じる
    }
}