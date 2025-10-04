package lotto.exception;

public enum ErrorMessage {
    EMPTY_INPUT("[ERROR] 입력값이 비어있습니다."),
    INVALID_PRICE("[ERROR] 1000단위의 금액을 입력해주세요"),
    NOT_UNIQUE_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    INVALID_NUMBER_LENGTH("[ERROR] 로또 번호는 6개여야합니다."),
    INVALID_NUMBER_RANGE("[ERROR] 로또 번호는 1~45 사이 숫자여야합니다."),
    NOT_INTEGER_NUMBER("[ERROR] 로또 번호는 숫자여야합니다.");

    private final String message;

    ErrorMessage(String message){
        this.message=message;
    }
    public String getMessage(){
        return message;
    }

}
