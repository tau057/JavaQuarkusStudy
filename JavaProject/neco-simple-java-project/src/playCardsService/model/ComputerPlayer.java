package playCardsService.model;

// コンピュータープレイヤークラス
public class ComputerPlayer extends Participant {

    public ComputerPlayer(String name) {
        super(name);
    }

    // カードを引くか否か決定して返す
    // コンピュータープレイヤー固有の処理
    public boolean isDraw() {
        return this.point() <= 17;
    }

}
