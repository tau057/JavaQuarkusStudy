// import culcService.service.CulcService;
// import makeCarsService.service.MakeCarsService;

import playCardsService.controller.PlayCardsController;

public class App {

    public static void main(String[] args) throws Exception {

        // 累乗計算のサービス呼び出し
        // CulcService.excute(); // staticメソッドなので、インスタンス生成しないで呼び出し可能

        // 車作成サービスの呼び出し
        // MakeCarsService carsService = new MakeCarsService();
        // carsService.execute();

        // トランプゲームサービス
        PlayCardsController trumpService = new PlayCardsController();
        trumpService.execute();
    }

}
