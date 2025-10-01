package lotto.util;

public enum ErrorMessage {
    ERROR_INPUT_PRICE_RANGE("[ERROR] 금액은 최소 1000원 에서 최대 100,000원 까지 가능합니다."),
    ERROR_INPUT_PRICE_UNIT("[ERROR] 금액은 1000원 단위로 입력해야합니다."),
    ERROR_INPUT_NUMBER_RANGE("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자여야 합니다."),
    ERROR_INPUT_NUMBER_COUNT("[ERROR] 로또 번호는 6개 입력해야합니다."),
    ERROR_INPUT_NUMBER_DUPLICATE("[ERROR] 로또 번호는 중복될 수 없습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
