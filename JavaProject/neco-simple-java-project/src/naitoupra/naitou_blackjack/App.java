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

        // for (int i = 1; i <= 10; i++) {
        // int mod3 = i % 3;
        // int mod2 = i % 2;
        // int mod5 = i % 5;

        // if (mod3 == 0) {
        // System.out.println(i + "は、３の倍数です");
        // } else if (mod2 == 0) {
        // System.out.println(i + "は、２の倍数です");
        // } else if (mod5 == 0) {
        // System.out.println(i + "は、５の倍数です");
        // } else {
        // System.out.println(i + "は、２と３と５の倍数ではありません");
        // }
        // }
        // }
        // }

        // int[] points = new int[7];
        // // [xx xx xx xx xx] ←イメージ
        // // [0 1 2 3 4] ←インデックス（xx番目）

        // points[0] = 67;
        // points[1] = 38;
        // points[2] = 78;
        // points[3] = 57;
        // points[4] = 94;
        // points[5] = 75;
        // points[6] = 20;
        // // [67,38,78,57,94]
        // // System.out.println(points[3]);

        // int arraysize = points.length;

        // for (int i = 0; i < arraysize; i++) {
        // System.out.println(points[i]);
        // }
        // リストの宣言
        // int[] points = new int[5];これに相当
        List<Integer> array = new ArrayList<>();// いくらでも要素は追加できる：サイズ指定の必要はない。

        // [xx xx xx xx xx ...]←イメージ
        // [0 1 2 3 4 ...]←インデックス

        // 要素の追加 points[0] = 67；←これに相当
        // 0番目から順に入っていく。
        array.add(67);
        array.add(38);
        array.add(78);
        array.add(57);
        array.add(94);
        // array.add(2,78);// インデックスも取得できる（関連：オーバーロード）
        // 要素の取得
        int arraySize = array.get(0);// ラッパークラスなので、int型でも受け取れる。
        for (int i = 0; i < arraySize; i++) {
            System.out.println(array.get(i));
        }
    }
}