package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.RequestDTO;
import lotto.util.Message;
import lotto.util.Validator;

public class InputView {

    public int getPrice() {
        System.out.println(Message.REQUIRE_INPUT_PRICE);
        int price = Integer.parseInt(Console.readLine().strip());
        Validator.priceRange(price);
        Validator.priceUnit(price);
        return price;
    }

    public List<Integer> getTargetNumbers() {
        System.out.println(Message.REQUIRE_INPUT_TARGET_NUMBERS);
        List<Integer> targetNumber = Arrays.stream(Console.readLine()
                        .strip()
                        .split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        Validator.numbersRange(targetNumber);
        return targetNumber;
    }

    public int getBonusNumber() {
        System.out.println(Message.REQUIRE_INPUT_BONUS_NUMBER);
        int bonusNumber = Integer.parseInt(Console.readLine().strip());
        Validator.numberRange(bonusNumber);
        return bonusNumber;
    }

    public RequestDTO getInput() {
        int price = getPrice();
        List<Integer> targetNumbers = getTargetNumbers();
        int bonusNumber = getBonusNumber();
        return new RequestDTO(price, targetNumbers, bonusNumber);
    }
}
