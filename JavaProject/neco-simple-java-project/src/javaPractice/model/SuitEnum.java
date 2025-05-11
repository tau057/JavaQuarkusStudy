package javaPractice.model;

public enum SuitEnum {

    SPADE("スペード"),
    HEART("ハート"),
    DIA("ダイヤ"),
    CLUB("クラブ");

    String name;

    /* コンストラクタ */
    private SuitEnum(String name) {
        this.name = name;
    }

    /* アクセサ */
    public String getName() {
        return this.name;
    }

}
