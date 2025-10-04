package lotto.util;

import java.util.List;

import static lotto.constant.ErrorMessage.*;

public class Validator {
    public static void validateEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT_ERROR.getMessage());
        }
    }

    public static void validatePositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR.getMessage());
        }
    }

    public static void validateAmountOver(int value) {
        if (value > 100000) {
            throw new IllegalArgumentException(MAX_PURCHASE_AMOUNT_ERROR.getMessage());
        }
    }

    public static void validateAmountUnit(int value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT_ERROR.getMessage());
        }
    }

    public static void validateLottoNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    public static void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateLottoNumberRange(number);
        }
    }

    public static void validateWinningNumberCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR.getMessage());
        }
    }

    public static void validateLottoNumberUnique(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != lottoNumbers.stream().distinct().toList().size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_NOT_UNIQUE_ERROR.getMessage());
        }
    }
}
