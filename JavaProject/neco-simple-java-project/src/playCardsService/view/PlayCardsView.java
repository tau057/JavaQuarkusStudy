package playCardsService.view;

import java.util.List;

import playCardsService.model.Card;
import playCardsService.model.ComputerPlayer;
import playCardsService.model.Participant;
import playCardsService.model.Player;

// トランプゲームに使用されるビュークラス
public class PlayCardsView {

    private static final String BORDER_STR = "====================";
    private static final String DICISION_MEMBER = "のプレイ人数を入力してください";
    private static final String DICISION_MEMBER_ERROR = "範囲内の数値を入力してください";
    private static final String START_STR = "を開始します";
    private static final String ASK_DRAW = "カードを引きますか？[y,n]";
    private static final String ASK_DRAW_ERROR = "[y,n]のいずれかを入力してください";
    private static final String DURING_STATE_STR = "手札の状態";
    private static final String FINISH_STATE_STR = "最終結果";
    private static final String END_STR = "を終了します";
    private static final String DUMMY_CARD = "[??/??]";
    private static final String DUMMY_CARD_SPACE = ".......";

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RESET = "\u001B[0m";

    // メンバー決定時のメッセ―ジ
    public static void dicisionMemberAnnounce(String gameName, int min, int max) {
        String announceStr = gameName + DICISION_MEMBER;
        String announceStr2 = "[" + min + " ~ " + max + "]";
        dispBorder();
        dispAnnounce(announceStr);
        dispAnnounce(announceStr2);
        dispBorder();
    }

    // メンバー決定時のメッセ―ジ（エラー）
    public static void dicisionMemberErrorAnnounce() {
        dispAnnounce(DICISION_MEMBER_ERROR);
    }

    // 開始時のメッセージ
    public static void startAnnounce(String gameName) {
        String announceStr = gameName + START_STR;
        dispBorder();
        dispAnnounce(announceStr);
        dispBorder();
    }

    // ゲーム中の手札確認メッセージ
    public static void askDrawAnnounce() {
        dispBorder();
        dispAnnounce(ASK_DRAW);
        dispBorder();
    }

    // ゲーム中の手札確認メッセージ(エラー)
    public static void askDrawErrorAnnounce() {
        dispAnnounce(ASK_DRAW_ERROR);
    }

    // ゲーム中の手札確認メッセージ
    public static void duringHandAnnounce() {
        dispBorder();
        dispAnnounce(DURING_STATE_STR);
        dispBorder();
    }

    // ゲーム終了時の手札確認メッセージ
    public static void finishHandAnnounce() {
        dispBorder();
        dispAnnounce(FINISH_STATE_STR);
        dispBorder();
    }

    // 終了時のメッセージ
    public static void endAnnounce(String gameName) {
        String announceStr = gameName + END_STR;
        dispBorder();
        dispAnnounce(announceStr);
        dispBorder();
    }

    // プレイヤーの手札を表示する
    public static void dispHand(Participant participant, boolean isDuring, int turnNo) {

        int index = 0;
        boolean isYou = participant instanceof Player;
        boolean isCom = participant instanceof ComputerPlayer;
        boolean isStay = participant.getIsStay();
        boolean isBurst = participant.isBurst();
        boolean isBlackJack = participant.isBlackJack();

        // 文字列の初期値（状態によって背景色変化）
        String announceStr = "";
        if (isBurst) {
            announceStr += ANSI_RED_BACKGROUND;
        } else if (isYou) {
            announceStr += ANSI_CYAN_BACKGROUND;
        } else if (isBlackJack && !isDuring) {
            announceStr += ANSI_GREEN_BACKGROUND;
        }
        announceStr += participant.getActorName() + "\t: ";

        for (Card card : participant.getHand()) {
            // 以下の条件をすべて満たす場合、カードを隠す
            // ・ゲーム途中である
            // ・コンピュータプレイヤーである
            // ・バーストしていない
            // ・二枚目以降のカードである
            if (isDuring && isCom && !isBurst && index > 0) {
                announceStr += DUMMY_CARD;
            } else {
                announceStr += card.toString();
            }
            index++;
        }

        /* 以降カード表示後の追記処理 */

        // 追記前に、カードを一番多く引いているプレイヤーに表示位置を合わせる処理
        int diffCardNo = turnNo - (participant.getNumObHand() - 1);
        for (int i = 0; i < diffCardNo; i++) {
            announceStr += DUMMY_CARD_SPACE;
        }

        // 以下の条件をすべて満たす場合に、ステイ中表示する
        // ・ゲーム途中である
        // ・コンピュータプレイヤーである
        // ・バーストしていない
        // ・プレイヤー自身のステイのフラグが立っている
        if (isDuring && isCom && !isBurst && isStay) {
            // ゲーム中かつプレイヤーがステイ中の場合は、その旨を追記する
            announceStr += " STAY";
        }

        // 以下の条件の ”いずれかを” 満たす場合に、総得点を表示する
        // ・ゲーム途中でない
        // ・操作プレイヤーである
        // ・バーストしている
        if (!isDuring || isYou || isBurst) {
            // ゲーム中でないか、自分自身の場合は、総得点を追記する
            announceStr += " total = " + participant.point();
        }

        // 以下の条件をすべて満たすCPUに、ブラックジャックと表示する
        // ・ゲーム途中でない
        // ・ブラックジャックである
        // 自分自身の場合は、ゲーム途中であるか否かにかかわらずBJ表記
        if (isCom && !isDuring && isBlackJack) {
            // ゲーム中かつプレイヤーがステイ中の場合は、その旨を追記する
            announceStr += " BLACK JACK!!";
        } else if (!isCom && isBlackJack) {
            announceStr += " BLACK JACK!!";
        }

        // バーストしているプレイヤーは無条件でバースト表示
        if (isBurst) {
            // ゲーム中かつプレイヤーがステイ中の場合は、その旨を追記する
            announceStr += " BURST...";
        }

        // カラーリセットの文字列を最後に挿入
        announceStr += ANSI_RESET;

        dispAnnounce(announceStr);
    }

    // 勝者のプレイヤーのリストから、勝者の名前をリスト表示する
    public static void dispWinner(List<Participant> winners) {
        String announceStr = "勝者：";
        for (Participant player : winners) {
            announceStr += player.getActorName();
        }
        dispBorder();
        dispAnnounce(announceStr);
        dispBorder();
    }

    // ターミナルへの文字列表示用の共通メソッド
    private static void dispAnnounce(String announceStr) {
        System.out.println(announceStr);
    }

    private static void dispBorder() {
        System.out.println(BORDER_STR);
    }

}
