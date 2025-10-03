package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_PURCHASE_AMOUNT = "\n구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public String readPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public String readWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        return Console.readLine();
    }
}
