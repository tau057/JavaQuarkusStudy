package playCardsService.controller;

import playCardsService.service.BlackJackManager;

public class PlayCardsController {

    public void execute() {

        // マネージャー新規作成
        BlackJackManager bjmanager = new BlackJackManager("ブラックジャック");

        // ゲーム開始時処理
        bjmanager.startGame();

        // ゲーム中処理
        bjmanager.duringGame();

        // ゲーム終了時処理
        bjmanager.endGame();

    }
}
