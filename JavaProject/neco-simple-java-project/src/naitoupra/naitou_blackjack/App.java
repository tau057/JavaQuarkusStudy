package naitoupra.naitou_blackjack;

import java.util.ArrayList;
import java.util.List;

public class App {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // 「card_A1」というインスタンスを生成する。
        // クラス名 変数名 ＝ new コンストラクタ
        // Card card_A1 = new Card("スペード", 1);

        // System.out.println(card_A1.getSuit() + "の" + card_A1.getNumer() + "です");

        // 2025.6.22 「課題２」
        // int count = 0;
        // for (int i = 1; i <= 10; i++) {
        // count = count + i;
        // }
        // System.out.println(count);

        // 2025.6.22 リスト作成
        // List<String> animal = new ArrayList<>();

        // animal.add("クマ");// 0
        // animal.add("アヒル");// 1
        // animal.add("ウシ");// 2

        // for (int i = 0; i < 3; i++) {
        // System.out.println(animal.get(i));
        // }

        // int kuku = 2;
        // for (int i = 1; i <= 9; i++) {
        // int result = kuku * i;
        // System.out.println(result);
        // }

        // 2025.7.20 １～１００を足す
        // int add = 0;
        // for (int i = 1; i <= 100; i++) {
        // int result2 = add + i;
        // System.out.println(result2);
        // }

        // 回答
        // int sum = 0;
        // for (int i = 1; i <= 100; i++) {
        // sum += i;
        // }
        // System.out.println("sum:1~100 = " + sum);

        // 1~100までくりかえし
        // ３の倍数の時だけ表示
        // for (int i = 1; i <= 100; i++) {

        // %はmod 剰余の演算
        // int mod = i % 3;

        // if (mod == 0) {
        // System.out.println(i);
        // }
        // }

        // １～１０の間で、3の倍数を区別
        // for (int i = 1; i <= 10; i++) {
        // int mod = i % 3;

        // if (mod == 0) {
        // System.out.println(i + "は、３の倍数ではありません");
        // } else {
        // System.out.println(i + "は、３の倍数ではない");
        // }
        // }

        for (int i = 1; i <= 10; i++) {
            int mod3 = i % 3;
            int mod2 = i % 2;
            int mod5 = i % 5;

            if (mod3 == 0) {
                System.out.println(i + "は、３の倍数です");
            } else if (mod2 == 0) {
                System.out.println(i + "は、２の倍数です");
            } else if (mod5 == 0) {
                System.out.println(i + "は、５の倍数です");
            } else {
                System.out.println(i + "は、２と３と５の倍数ではありません");
            }
        }
    }
}