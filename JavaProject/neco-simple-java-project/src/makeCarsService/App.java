package makeCarsService;

import makeCarsService.service.MakeCarsService;

public class App {

    public static void main(String[] args) throws Exception {

        // 車作成サービスの呼び出し
        MakeCarsService carsService = new MakeCarsService();
        carsService.execute();

    }

}
