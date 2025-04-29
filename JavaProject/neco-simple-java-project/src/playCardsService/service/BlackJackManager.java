package playCardsService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import playCardsService.model.Card;
import playCardsService.model.ComputerPlayer;
import playCardsService.model.Dealer;
import playCardsService.model.Deck;
import playCardsService.model.Participant;
import playCardsService.model.Player;
import playCardsService.view.PlayCardsView;

// ブラックジャックの進行を行うクラス
public class BlackJackManager extends GameManager {

    private static final int MEMBER_MIN = 2;
    private static final int MEMBER_MAX = 10;

    // コンソール入力を行うための変数（おまじない）
    Scanner sc = new Scanner(System.in);

    // プレイヤー
    private List<Participant> players;
    // トランプ
    private Deck deck;
    // 経過ターン数
    private int turnNo;

    public BlackJackManager(String gameName) {
        // 初期化時に、ゲーム名称とビューのインスタンスを作成
        super(gameName);
    }

    /**
     * ゲーム開始時
     **/
    @Override
    public void startGame() {

        // 人数決定
        PlayCardsView.dicisionMemberAnnounce(gameName, MEMBER_MIN, MEMBER_MAX);
        int numOfPlayer;
        while (true) {
            String inputStr = sc.next();
            // 数値が入力され、それが最小/最大値なら人数を決定してwhileを抜ける
            try {
                numOfPlayer = Integer.parseInt(inputStr);
                if (numOfPlayer >= MEMBER_MIN && numOfPlayer <= MEMBER_MAX) {
                    break;
                } else {
                    PlayCardsView.dicisionMemberErrorAnnounce();
                }
            } catch (NumberFormatException ex) {
                PlayCardsView.dicisionMemberErrorAnnounce();
            }
        }
        // 決定した人数だけ、プレイヤーのリストに追加する
        players = new ArrayList<>();
        players.add(new Dealer("Dealer")); // ディーラー
        players.add(new Player("you")); // プレイヤー
        for (int i = 0; i < numOfPlayer - 2; i++) {
            String playerName;
            playerName = "com" + (i + 1);
            players.add(new ComputerPlayer(playerName)); // 他はみんなCPU
        }

        // デッキの新規作成・シャッフル
        deck = new Deck();

        // ゲーム開始announce
        PlayCardsView.startAnnounce(gameName);
    }

    /**
     * ゲーム中
     **/
    @Override
    public void duringGame() {

        // 各プレイヤーにまず２枚ずつカードを渡す
        for (Participant player : players) {
            handOverCard(player, 2);
        }

        // 終了条件を満たすまでループ
        turnNo = 0;
        while (true) {
            // 経過ターン数加算
            turnNo++;

            // 操作プレイヤーがステイ状態か算出
            boolean amIStay = !players.stream()
                    .filter(x -> x instanceof Player && x.getIsStay())
                    .toList()
                    .isEmpty();

            // 自身がstayではない場合のみ、現在の手札の状況を表示
            if (!amIStay) {
                PlayCardsView.duringHandAnnounce();
                for (Participant player : players) {
                    PlayCardsView.dispHand(player, true, turnNo);
                }
            }

            // 各プレイヤーの行動
            for (Participant player : players) {
                // ステイ中でないプレイヤーのみ行動
                if (!player.getIsStay()) {
                    if (player instanceof Player) {
                        // 自分自身
                        PlayCardsView.askDrawAnnounce();
                        while (true) {
                            String inputStr = sc.next();
                            if ("y".equals(inputStr)) {
                                handOverCard(player, 1);
                                break;
                            } else if ("n".equals(inputStr)) {
                                player.setIsStay(true);
                                break;
                            } else {
                                PlayCardsView.askDrawErrorAnnounce();
                            }
                        }
                    } else {
                        // コンピュータプレイヤー
                        var com = (ComputerPlayer) player;
                        if (com.isDraw()) {
                            // 一枚ドロー
                            handOverCard(player, 1);
                        } else {
                            // 引かない場合はステイ状態に遷移
                            player.setIsStay(true);
                        }
                    }
                }
            }

            // ステイしていないプレイヤーがいる場合継続
            // ただし、そのプレイヤーがバーストかBJの場合は無視したうえでステイ状態に遷移させる
            boolean existDontStay = false;
            for (Participant player : players) {
                if (!player.getIsStay()) {
                    if (player.isBurst() || player.isBlackJack()) {
                        player.setIsStay(true);
                    } else {
                        existDontStay = true;
                    }
                }
            }
            if (!existDontStay) {
                break;
            }
        }
    }

    // プレイヤーに、デッキから指定枚数カードを渡す
    private void handOverCard(Participant player, int numOfCard) {
        for (int i = 0; i < numOfCard; i++) {
            Card card = deck.pick();
            player.addHand(card);
        }
    }

    /**
     * ゲーム終了時
     **/
    @Override
    public void endGame() {
        // 終了時の手札の状況を表示
        PlayCardsView.finishHandAnnounce();
        for (Participant player : players) {
            PlayCardsView.dispHand(player, false, turnNo + 1);
        }

        // 勝者の表示
        PlayCardsView.dispWinner(
                BlackJackRules.getWinnerList(players));

        // ゲームの終了表示
        PlayCardsView.endAnnounce(gameName);

    }

}
