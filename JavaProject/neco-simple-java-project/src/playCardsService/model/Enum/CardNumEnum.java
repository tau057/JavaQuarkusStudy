package playCardsService.model.Enum;

public enum CardNumEnum {

    ACE("A", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 11),
    QUEEN("Q", 12),
    KING("K", 13);

    // Enumが持つ属性
    private String label;
    private int number;

    // Enumのコンストラクタはprivateで宣言
    private CardNumEnum(String label, int number) {
        this.label = label;
        this.number = number;
    }

    // Enumが持つ属性に対するアクセサ（セッターは存在しない）
    public String getLabel() {
        return label;
    }

    public int getNumber() {
        return number;
    }

}
