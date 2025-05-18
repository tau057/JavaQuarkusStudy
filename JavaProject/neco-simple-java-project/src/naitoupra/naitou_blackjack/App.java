package naitoupra.naitou_blackjack;

public class App {

    public static void main(String[] args) throws Exception {

        // 「card_A1」というインスタンスを生成する。
        // クラス名 変数名 ＝ new コンストラクタ
        Card card_A1 = new Card("スペード", 1);

        System.out.println(card_A1.getSuit() + "の" + card_A1.getNumer() + "です");

    }

}
