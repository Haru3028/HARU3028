import java.util.Random;

// 子クラス：破道

/*
 * 　クラス　Hadoは死神が使用する破道を実装する
 */
public class Hado extends Shinigami {

    /*
     * 死神が使用する破道一覧の配列
     */
    private static final String[][] HADO_SPELLS = {
        {"1","衝"},{"4","白雷"},{"11","綴雷電"},{"31","赤火砲"},{"32","黄火閃"},{"33","蒼火墜"},
        {"54","廃炎"},{"57","大地転踊"},{"58","闐嵐"},{"63","雷吼炮"},{"73","双連蒼火墜"},
        {"78","斬華輪"},{"88","飛竜撃賊震天雷炮"},{"90","黒棺"},{"91","千手皎天汰炮"},{"96","一刀火葬"},{"99","五龍転滅"}
    };

    /*
     * 
     * 指定された名前の破道を使用する死神のインスタンスを生成
     * 
     * @param　name 死神の名前
     */
    public Hado(String name) {
        super(name);
        Random random = new Random();
        int index = random.nextInt(HADO_SPELLS.length);

        // 正しい番号と技名を一致させる
        this.number = Integer.parseInt(HADO_SPELLS[index][0]);
        this.spellName = HADO_SPELLS[index][1];
    }

    /*
     * 死神が破道を使用する動作を実行
     */

    @Override
    public void useSpell() {
        System.out.println(name + "は破道の" + number + spellName + "を使った");
    }
}
