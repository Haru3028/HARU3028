import java.util.Random;

// 子クラス：縛道

/*
 *  クラス　Hadoは死神が使用する破道を実装する
 */
public class Bakudo extends Shinigami {
    /*
     * 死神が使用する縛道一覧の配列
     */
    private static final String[][] BAKUDO_SPELLS = {
        {"1", "塞"},{"4", "這縄"},{"8","斥"},{"21","赤煙遁"},{"26","曲光"},
        {"30","嘴突三閃"},{"37","吊星"},{"39","円閘扇"},{"58","掴趾追雀"},
        {"61","六杖光牢"},{"62","百歩欄干"},{"63","鎖条鎖縛"},{"73","倒山晶"},
        {"75","五柱鉄貫"},{"77","天挺空羅"},{"79","九曜縛"},{"81","断空断空"},
        {"99","禁"},{"99第2番","卍禁"}
    };

     /*
     * 指定された名前の縛道を使用する死神のインスタンスを生成
     * 
     * @param name 死神の名前
     * 
     */
    public Bakudo(String name) {
        super(name);
        Random random = new Random();
        int index = random.nextInt(BAKUDO_SPELLS.length);

        // 正しい番号と技名を一致させる
        this.number = Integer.parseInt(BAKUDO_SPELLS[index][0]);
        this.spellName = BAKUDO_SPELLS[index][1];
    }

    /*
     * 死神が縛道を使用する動作を実行
     */
    @Override
    public void useSpell() {
        System.out.println(name + "は縛道の" + number + spellName + "を使った!!!");
    }
}