package playCardsService;

import playCardsService.controller.PlayCardsController;

public class App {

    public static void main(String[] args) throws Exception {

        // トランプゲームサービス
        PlayCardsController trumpService = new PlayCardsController();
        trumpService.execute();
    }

}
