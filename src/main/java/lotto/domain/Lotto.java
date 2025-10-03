package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.ErrorMessage.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.util.Validator.validateLottoNumberUnique;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR.getMessage());
        }

        validateLottoNumberUnique(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers.stream().sorted().toList();
    }

    public int getWinningNumberCount(List<Integer> winningNumber) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        Set<Integer> winningNumberSet = new HashSet<>(winningNumber);
        numbersSet.retainAll(winningNumberSet);
        return numbersSet.size();
    }

    public boolean checkBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
