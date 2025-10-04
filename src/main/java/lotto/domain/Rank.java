package lotto.domain;

public enum Rank{
    RANK_6("6개 일치 (2,000,000,000원)"),
    RANK_5b("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    RANK_5("5개 일치 (1,500,000원)"),
    RANK_4("4개 일치 (50,000원)"),
    RANK_3("3개 일치 (5,000원)");

    private final String description;
    Rank(String description){
        this.description=description;
    }
    public String getDescription(){
        return description;
    }
}
