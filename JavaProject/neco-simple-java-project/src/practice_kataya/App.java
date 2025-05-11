package practice_kataya;

public class App {

    public static void main(String[] args) throws Exception {

        // 引数なしコンストラクタでbookobjAを作成する
        Book bookobjA = new Book();

        // bookAの著者名をBookクラスに設定する
        bookobjA.setName("俺たちバブル入行組");
        bookobjA.setPrice(600);
        bookobjA.setAuther("池井戸潤");

        // 引数ありコンストラクタでbookobjBを作成する
        Book bookobjB = new Book("下町ロケット", 500, "池井戸潤");

        System.out.println(bookobjB.getName());

    }

}
