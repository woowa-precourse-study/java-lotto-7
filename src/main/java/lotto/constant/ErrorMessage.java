package lotto.constant;

public enum ErrorMessage {
    LOTTO_NUMBER_COUNT_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    BONUS_NUMBER_NOT_UNIQUE_ERROR("[ERROR] 보너스 번호는 당첨 번호와 달라야 합니다."),
    INVALID_INPUT_FORMAT_ERROR("[ERROR] 올바르지 않은 형식의 입력입니다."),
    NOT_POSITIVE_ERROR("[ERROR] 양수를 입력해주세요."),
    MAX_PURCHASE_AMOUNT_ERROR("[ERROR] 최대 10만원까지만 구매 가능합니다."),
    PURCHASE_AMOUNT_UNIT_ERROR("[ERROR] 1000원 단위로 입력해주세요."),
    LOTTO_NUMBER_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_NOT_UNIQUE_ERROR("[ERROR] 로또 번호는 중복이 없어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
