package javaPractice.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    /* 属性 */
    List<Card> cards;

    /* コンストラクタ */
    public Deck() {
        this.shuffle();
    }

    /* 全てのカードを表示するメソッド */
    public void openAll() {
        for (Card card : cards) {
            card.openFace();
        }
    }

    /* 山札を初めの状態に戻すメソッド */
    public void shuffle() {
        cards = new ArrayList<>(); // リストの初期化を忘れずに
        for (SuitEnum suit : SuitEnum.values()) {
            for (int i = 1; i <= 13; i++) {
                cards.add(new Card(suit, i));
            }
        }
    }

}
