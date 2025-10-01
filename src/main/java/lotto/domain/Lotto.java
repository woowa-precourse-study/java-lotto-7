package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.util.Validator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        Validator.numbersRange(numbers);
        Validator.numberDuplicate(numbers);
    }

    // TODO: 추가 기능 구현

    // 만들어진 난수 정답과 일치하는지 확인
    public List<Integer> checkLottos(List<List<Integer>> lottos) {
        List<Integer> matchingNumbers = new ArrayList<>();
        for (List<Integer> numbers : lottos) {
            matchingNumbers.add(checkLotto(numbers));
        }
        return matchingNumbers;
    }

    public int checkLotto(List<Integer> lotto){
        int count = 0;
        for(int i = 0 ; i < 6; i++){
            if(lotto.contains(numbers.get(i))){
                count +=1;
            }
        }
        return count;
    }

    // 수익률을 계산
    public void calculateProfit() {

    }
}
