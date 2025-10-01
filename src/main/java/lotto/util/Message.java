package lotto.util;

public enum Message {
    REQUIRE_INPUT_PRICE("구입금액을 입력해 주세요."),
    REQUIRE_INPUT_TARGET_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUIRE_INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
