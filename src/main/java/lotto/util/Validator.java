package lotto.util;

import java.util.List;
import lotto.view.InputView;

public class Validator {

    public static void priceRange(int price) {
        if (price < 1000 || price > 100000) {
            throw new IllegalArgumentException(
                    String.valueOf(ErrorMessage.ERROR_INPUT_PRICE_RANGE));
        }
    }

    public static void priceUnit(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(String.valueOf(ErrorMessage.ERROR_INPUT_PRICE_UNIT));
        }
    }

    public static void numberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(
                    String.valueOf(ErrorMessage.ERROR_INPUT_NUMBER_RANGE));
        }
    }

    public static void numbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            numberRange(number);
        }
    }


}
