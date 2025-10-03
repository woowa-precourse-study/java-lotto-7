package lotto.util;

public enum Win {
    MATCH_3("5,000"),
    MATCH_4("50,000"),
    MATCH_5("1,500,000"),
    MATCH_5_AND_BONUS("30,000,000"),
    MATCH_6("2,000,000,000");


    private final String value;
    private Win(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
