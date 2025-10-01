package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.dto.RequestDTO;
import lotto.util.Message;
import lotto.util.Validator;

public class InputView {

    private static int getPrice() {
        System.out.println(Message.REQUIRE_INPUT_PRICE.getMessage());
        int price = Integer.parseInt(Console.readLine().strip());
        Validator.priceRange(price);
        Validator.priceUnit(price);
        return price;
    }

    private static List<Integer> getTargetNumbers() {
        System.out.println(Message.REQUIRE_INPUT_TARGET_NUMBERS.getMessage());
        List<Integer> targetNumber = Arrays.stream(Console.readLine()
                        .strip()
                        .split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        Validator.numbersRange(targetNumber);
        return targetNumber;
    }

    private static int getBonusNumber() {
        System.out.println(Message.REQUIRE_INPUT_BONUS_NUMBER.getMessage());
        int bonusNumber = Integer.parseInt(Console.readLine().strip());
        Validator.numberRange(bonusNumber);
        return bonusNumber;
    }

    public static RequestDTO getInput() {
        return new RequestDTO(getPrice());
    }
}
