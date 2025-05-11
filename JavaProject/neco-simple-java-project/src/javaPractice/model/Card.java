package javaPractice.model;

public class Card {

    /* 属性 */
    private SuitEnum suit; // スート
    private int number; // 数値

    /* コンストラクタ */
    public Card(SuitEnum suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    /* アクセサ */
    public SuitEnum getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }

    // 自身の情報を表示するメソッド
    public void openFace() {
        System.out.println(this.suit.getName() + "の" + this.number);
    }

}
