// 親クラス：死神

/*
 * 
 * 抽象クラス　Shinigami　
 * 死神（人物）の基本的な属性と動作を定義します
 */
public abstract class Shinigami {
    protected String name;  // 死神の名前
    protected int number;  // 呪文の番号
    protected String spellName;  // 呪文の名前

    /*
     * 死神の名前を指定してインスタンスを作成
     * 
     * @param name 死神の名前
     * 
     */
    public Shinigami(String name) {
        this.name = name;
    }

    /*
     * 死神が鬼道（縛道、破道の二種）を使用するための抽象メソッド
     * サブクラスで具体的に実装
     */

    public abstract void useSpell();  // 抽象メソッド
}