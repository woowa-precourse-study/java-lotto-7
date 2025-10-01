package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void priceRange(int price) {
        if (price < 1000 || price > 100000) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_INPUT_PRICE_RANGE.getMessage());
        }
    }

    public static void priceUnit(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_INPUT_PRICE_UNIT.getMessage());
        }
    }

    public static void numberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_INPUT_NUMBER_RANGE.getMessage());
        }
    }

    public static void numbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            numberRange(number);
        }
    }

    public static void numberDuplicate(List<Integer> numbers) {
        Set<Integer> unique = new HashSet<>(numbers);
        if (unique.size() != numbers.size()) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR_INPUT_NUMBER_DUPLICATE.getMessage());
        }
    }

}
