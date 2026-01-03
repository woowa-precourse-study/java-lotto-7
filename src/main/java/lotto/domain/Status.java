package lotto.domain;

public enum Status {
    NONE(2,false,0,""),
    FIFTH(3,false,5000,"3개 일치"),
    FOURTH(4,false,50000,"4개 일치"),
    THIRD(5,false,1500000,"5개 일치"),
    SECOND_BONUS(5,true,30000000,"5개 일치, 보너스 볼 일치"),
    FIRST(6,false,2000000000,"6개 일치");


    private final int count;
    private final boolean isBonus;
    private final int price;
    private final String message;

    Status(int count, boolean isBonus, int price,String message) {
        this.count = count;
        this.isBonus = isBonus;
        this.price = price;
        this.message=message;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public String getMessage(){return message;}

    public static Status fromMatch(int match,boolean isBonusMatch){
        if (match==5 && isBonusMatch==true){
            return SECOND_BONUS;
        }

        if (match<3){
            return NONE;
        }

        for (Status status:Status.values()){
            if (status.count==match){
                return status;
            }
        }
        throw new IllegalArgumentException("[ERROR] 해당 Enum이 존재하지 않습니다.");
    }

}
