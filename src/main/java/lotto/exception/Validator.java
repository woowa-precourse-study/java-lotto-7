package lotto.exception;

public interface Validator {
    void validate(String input);


    static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 값은 입력할 수 없습니다.");
        }
    }

    static int validateIsNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }

    static void validatePrice(String input) {
        int value = validateIsNumber(input);
        if (value < 0 || value %1000!=0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위만 입력 가능합니다.");
        }
    }

}
