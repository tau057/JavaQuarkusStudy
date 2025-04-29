package playCardsService.service;

// ゲーム進行を行う抽象クラス
public abstract class GameManager {

    // ゲーム名
    protected String gameName;

    public GameManager(String gameName) {
        this.gameName = gameName;
    }

    // ゲーム開始時
    public abstract void startGame();

    // ゲーム中
    public abstract void duringGame();

    // ゲーム終了時
    public abstract void endGame();

}
