package lotto.domain;

import lotto.constant.Rank;

import java.util.List;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_NOT_UNIQUE_ERROR;
import static lotto.constant.Rank.*;

public class WinningNumber {
    private final List<Integer> winningNumber;
    private int bonusNumber = 0;
    private static WinningNumber winningNumberObject;

    private WinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public static WinningNumber getInstance(List<Integer> winningNumber) {
        if (winningNumberObject == null) {
            winningNumberObject = new WinningNumber(winningNumber);
        }

        return winningNumberObject;
    }

    public void setBonusNumber(int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_UNIQUE_ERROR.getMessage());
        }
        this.bonusNumber = bonusNumber;
    }

    public Rank getRank(Lotto lotto) {
        int matchedCount = lotto.getWinningNumberCount(winningNumber);
        boolean isSecond = lotto.checkBonusNumber(bonusNumber);
        if (matchedCount == 6) return FIRST;
        if (matchedCount == 5 && isSecond) return SECOND;
        if (matchedCount == 5) return THIRD;
        if (matchedCount == 4) return FOURTH;
        if (matchedCount == 3) return FIFTH;
        return null;
    }
}