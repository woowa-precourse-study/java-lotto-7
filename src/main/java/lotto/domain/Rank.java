package lotto.domain;

public enum Rank{
    RANK_3("3개 일치 (5,000원)",5000),
    RANK_4("4개 일치 (50,000원)",50000),
    RANK_5("5개 일치 (1,500,000원)",1500000),
    RANK_5b("5개 일치, 보너스 볼 일치 (30,000,000원)",30000000),
    RANK_6("6개 일치 (2,000,000,000원)",2000000000);





    private final String description;
    private final Integer amount;
    Rank(String description,Integer amount){
        this.description=description;
        this.amount=amount;
    }
    public String getDescription(){
        return description;
    }

    public Integer getAmount(){
        return amount;
    }
}
