package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RequestDTO {
    private final int price;
    private final List<Integer> targetNumbers;
    private final int bonusNumber;

    public RequestDTO(int price, List<Integer> targetNumbers, int bonusNumber) {
        this.price = price;
        this.targetNumbers = targetNumbers;
        this.bonusNumber = bonusNumber;
    }

}
