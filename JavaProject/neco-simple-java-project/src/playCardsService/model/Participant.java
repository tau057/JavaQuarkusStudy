package playCardsService.model;

import java.util.ArrayList;
import java.util.List;

import playCardsService.service.BlackJackRules;

// 参加者クラス（ディーラーとプレイヤーの親クラスとなるため抽象クラスにする）
public abstract class Participant {

    /* 属性 */
    // 役割の名前
    protected String actorName;
    // 手札
    protected List<Card> hand = new ArrayList<>();
    // ステイしているかどうか
    protected boolean isStay = false;

    /* コンストラクタ */
    public Participant(String actorName) {
        this.actorName = actorName;
    }

    /* メソッド */
    // 渡されたカードを手札に加える
    public void addHand(Card card) {
        hand.add(card);
    }

    // 手札の枚数取得
    public int getNumObHand() {
        return hand.size();
    }

    // ポイント計算
    public int point() {
        return BlackJackRules.culkHandSum(this.hand);
    }

    // バーストしているか
    public boolean isBurst() {
        return BlackJackRules.isBuest(this.point());
    }

    // ブラックジャックか
    public boolean isBlackJack() {
        return BlackJackRules.isBlackJack(this.point());
    }

    /* アクセサ */
    public boolean getIsStay() {
        return this.isStay;
    }

    public void setIsStay(boolean isStay) {
        this.isStay = isStay;
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public String getActorName() {
        return actorName;
    }
}
