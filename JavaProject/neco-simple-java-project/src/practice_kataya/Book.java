package practice_kataya;

public class Book {
    // *フィールド*
    // 文字列型：本の名前
    String name;

    // 数値型（整数）：価格
    int price;

    // 文字列型：著者
    String auther;

    // *メソッド*
    // A. 引数なしコンストラクタ
    Book() {

    }

    // B. 引数ありコンストラクタ
    Book(String name, int price, String auther) {
        this.name = name;
        this.price = price;
        this.auther = auther;
    }

    // アクセサ
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getName() {
        return "陸王";
    }

}