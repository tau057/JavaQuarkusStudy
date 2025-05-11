package javaPractice.model;

public enum SeasonEnum {

    SPRING("春"),
    SUMMER("夏"),
    AUTUMN("秋"),
    WINTER("冬");

    String jpnName;

    private SeasonEnum(String jpnName) {
        this.jpnName = jpnName;
    }

    public String getJpnName() {
        return this.jpnName;
    }
}
