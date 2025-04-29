package playCardsService.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import playCardsService.model.Enum.CardNumEnum;
import playCardsService.model.Enum.SuitEnum;

// デッキクラス
public class Deck {

    /* 属性 */
    // 山札のリスト
    private List<Card> cardList;
    // カードの残り枚数
    private int remainingNumber;

    /* コンストラクタ */
    // 引数無しコンストラクタの中で、初期化を行う
    public Deck() {
        initialize();
    }

    // デッキの初期化用のメソッド（コンストラクタ以外からも呼び出すので共通化）
    private void initialize() {
        // デッキのリスト初期化
        this.cardList = new ArrayList<>();
        // 残り枚数初期化
        this.remainingNumber = 0;

        // デッキの生成（スートと0~13までの数字をループさせる）
        for (SuitEnum suit : SuitEnum.values()) {
            for (CardNumEnum number : CardNumEnum.values()) {
                // ループ内のスートと数値の情報を使ってカードのインスタンスを生成、デッキのリストに加える
                Card card = new Card(suit, number);
                this.cardList.add(card);

                // デッキの残り枚数をインクリメント（＋１）
                this.remainingNumber++;
            }
        }
    }

    /* メソッド */
    // カードをランダムで一枚引いて返す
    // 引いたカードはリストから削除する
    public Card pick() {
        // 残り枚数が0枚の時はその旨を表示して処理終了
        if (remainingNumber <= 0) {
            System.out.println("山札にカードがありません");
            return null;
        }

        // 0以上残り枚数未満の数値をランダムで決定し、その数値の位置のカードを取得
        // インデックスは0から始まるのでね
        Random rand = new Random();
        int cardIndex = rand.nextInt(remainingNumber);
        Card drawCard = cardList.get(cardIndex);
        // ドローしたカードを削除
        cardList.remove(cardIndex);
        // 残り枚数デクリメント（-1）
        remainingNumber--;

        // ドローしたカードを返す
        return drawCard;

    }

    // デッキをリセットする
    public void reset() {
        initialize();
    }
}
