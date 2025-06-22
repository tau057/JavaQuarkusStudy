package naitoupra.naitou_blackjack;

//ここでクラスを作成
public class Card {

    String suit;
    int number;

    // 引数ありコンストラクタ（8～20行目）
    Card(String inputSuit, int inputNumber) {
        suit = inputSuit;
        number = inputNumber;
    }

    // ゲッター
    public String getSuit() {
        return suit;
    }

    public int getNumer() {
        return number;
    }
}
