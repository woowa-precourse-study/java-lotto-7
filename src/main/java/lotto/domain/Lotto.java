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

    // 난수 6개 리스트 생성하기
    public List<List<Integer>> generateLotto(int count) {
        List<List<Integer>> lotto = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            lotto.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return lotto;
    }

    // 만들어진 난수 정답과 일치하는지 확인
    public void checkLottos(List<List<Integer>> lottos) {

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
