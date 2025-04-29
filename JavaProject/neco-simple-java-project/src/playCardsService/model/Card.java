package playCardsService.model;

import playCardsService.model.Enum.CardNumEnum;
import playCardsService.model.Enum.SuitEnum;

// カードクラス
public class Card {

    /* 属性 */
    // スート（マーク）
    private SuitEnum suit;
    // 数値
    private CardNumEnum number;

    /* コンストラクタ */
    public Card(SuitEnum suit, CardNumEnum number) {
        this.suit = suit;
        this.number = number;
    }

    /* メソッド */
    // toStringをオーバーロードして、カードの情報を表示するメソッドとして扱う
    public String toString() {
        String numStr = this.number.getLabel();
        if (numStr.length() == 1) {
            numStr = " " + numStr;
        }
        return "[" + this.suit.getLabel() + " /" + numStr + "]";
    }

    /* アクセサ */
    // セッターが存在しないので、インスタンス生成後にカードの書き換えはできない
    public SuitEnum getSuit() {
        return suit;
    }

    public CardNumEnum getNumber() {
        return number;
    }
}