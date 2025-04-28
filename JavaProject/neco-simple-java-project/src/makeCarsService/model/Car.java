package makeCarsService.model;

public class Car {

    /* 属性 */

    // 車種：文字列型
    String model;

    // 走行処理：数値型（小数）
    double mileage;

    // 価格：数値型（整数）
    int price;

    /* コンストラクタ */

    // 1.引数無しコンストラクタ（デフォルトコンストラクタ）
    public Car() {
    }

    // 2.引数有りコンストラクタ
    public Car(String inputModel, double inputMileage, int inputPrice) {
        this.model = inputModel;
        this.mileage = inputMileage;
        this.price = inputPrice;
    }

    /* アクセサ（ゲッター・セッター） */

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
