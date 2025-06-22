package naitoupra.naitou_blackjack;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        // 「card_A1」というインスタンスを生成する。
        // クラス名 変数名 ＝ new コンストラクタ
        Card card_A1 = new Card("スペード", 1);

        System.out.println(card_A1.getSuit() + "の" + card_A1.getNumer() + "です");

        // 2025.6.22 「課題２」
        int count = 0;
        for (int i = 1; i <= 10; i++) {
            count = count + i;
        }
        System.out.println(count);

        // 2025.6.22 リスト作成
        List<String> animal = new ArrayList<>();

        animal.add("クマ");// 0
        animal.add("アヒル");// 1
        animal.add("ウシ");// 2

        for (int i = 0; i < 3; i++) {
            System.out.println(animal.get(i));
        }

        int kuku = 2;
        for (int i = 1; i <= 9; i++) {
            int result = kuku * i;
            System.out.println(result);

        }

    }

}