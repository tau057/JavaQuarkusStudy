package playCardsService.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import playCardsService.model.Card;
import playCardsService.model.Dealer;
import playCardsService.model.Participant;
import playCardsService.model.Enum.CardNumEnum;

// ブラックジャックの固有のルールを格納するクラス
public class BlackJackRules {

    // ブラックジャックとなる数値
    private static final int BLACK_JACK = 21;

    // 入力した手札のポイントを算出する
    public static int culkHandSum(List<Card> hand) {

        int handSum = 0;
        boolean isContainAce = false;

        // ACEが含まれていても、一旦１として手札の合計値計算
        for (Card card : hand) {
            CardNumEnum cardNumEnum = card.getNumber();
            int cardNo = cardNumEnum.getNumber();
            if (card.getNumber() == CardNumEnum.ACE) {
                isContainAce = true;
            } else if (card.getNumber() == CardNumEnum.JACK
                    || card.getNumber() == CardNumEnum.QUEEN
                    || card.getNumber() == CardNumEnum.KING) {
                cardNo = 10;
            }
            handSum += cardNo;
        }

        // 1が含まれており、11として扱っても問題ない場合は、合計値に10加算する
        if (isContainAce && (handSum + 10) <= BLACK_JACK) {
            handSum += 10;
        }

        return handSum;

    }

    // プレイヤーのリストを受け取り、勝者のプレイヤーのリストを還す
    public static List<Participant> getWinnerList(List<Participant> players) {
        // 返すリストを初期化
        List<Participant> winners = new ArrayList<>();

        // プレイヤー,得点のマップを作製
        Map<Participant, Integer> pMap = new HashMap<>();
        for (Participant player : players) {
            pMap.put(player, player.point());
        }

        // バーストしておらず、一番高いポイント取得
        OptionalInt maxOpt = pMap.values().stream()
                .filter(v -> v <= BLACK_JACK)
                .mapToInt(Integer::intValue)
                .max();

        // 上記の最大点数が存在する場合、その点数に該当するモノのみ抽出してリスト化
        if (maxOpt.isPresent()) {
            int max = maxOpt.getAsInt();
            winners = pMap.entrySet().stream()
                    .filter(e -> e.getValue() == max)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }

        // ディーラーがリスト内に存在する場合は、ディーラーの独り勝ち
        var checkList = winners.stream().filter(x -> x instanceof Dealer).toList();
        if (!checkList.isEmpty()) {
            winners = checkList;
        }

        return winners;

    }

    // 入力されたポイントがバーストしているか
    public static boolean isBuest(int point) {
        return point > BLACK_JACK;
    }

    // 入力されたポイントがBJか
    public static boolean isBlackJack(int point) {
        return point == BLACK_JACK;
    }

}
