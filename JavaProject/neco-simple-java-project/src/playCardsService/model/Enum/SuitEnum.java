package playCardsService.model.Enum;

public enum SuitEnum {

    SPADE("S"),
    HEART("H"),
    DIA("D"),
    CLUB("C");

    // Enumが持つ属性
    private String label;

    // Enumのコンストラクタはprivateで宣言
    private SuitEnum(String label) {
        this.label = label;
    }

    // Enumが持つ属性に対するアクセサ（セッターは存在しない）
    public String getLabel() {
        return label;
    }

}
