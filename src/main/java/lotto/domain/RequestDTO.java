package lotto.domain;

import java.util.List;

public class RequestDTO {
    private final int price;
    private final int lottoCount;
    private final List<Integer> targetNumbers;
    private final int bonusNumber;

    public RequestDTO(int price, List<Integer> targetNumbers, int bonusNumber) {
        this.price = price;
        this.lottoCount = price / 1000;
        this.targetNumbers = targetNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getPrice() {
        return price;
    }
    public List<Integer> getTargetNumbers() {
        return targetNumbers;
    }
    public int getBonusNumber() {
        return bonusNumber;
    }

}
