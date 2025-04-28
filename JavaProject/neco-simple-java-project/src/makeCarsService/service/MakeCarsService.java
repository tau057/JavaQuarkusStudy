package makeCarsService.service;

import makeCarsService.model.Car;

// 車クラスを定義し、インスタンスを作成するためのサービス
// 上記操作の練習のために作成しました
public class MakeCarsService {

    public void execute() {

        // インスタンスを作成方法その１
        Car carObjA = new Car();
        // インスタンスに車種の情報を登録する
        carObjA.setModel("prius");
        carObjA.setMileage(10000.5);
        carObjA.setPrice(2700000);
        // 「.」ドット演算子 → そのインスタンスが持っているメソッドを使うときに用いる

        // インスタンスを作成方法その２
        Car carObjB = new Car("fit", 5000.1, 1500000);

        // getterの使用例
        System.out.println("A_model:" + carObjA.getModel() + "/B_model:" + carObjB.getModel());

    }

}
