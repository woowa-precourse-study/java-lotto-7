package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static lotto.constant.ErrorMessage.INVALID_INPUT_FORMAT_ERROR;

public class Parser {
    private static final String DELIMITER = ",";

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input.strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT_ERROR.getMessage());
        }
    }

    public static List<Integer> parseInt(List<String> inputs) {
        List<Integer> inputList = new ArrayList<>();
        for (String input : inputs) {
            try {
                inputList.add(Integer.parseInt(input.strip()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(INVALID_INPUT_FORMAT_ERROR.getMessage());
            }
        }
        return inputList;
    }

    public static List<String> split(String input) {
        return Stream.of(input.strip().split(DELIMITER)).toList();
    }
}
