package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;

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
    }

    // TODO: 추가 기능 구현

    // 로또 번호 출력
    public void printNumbers() {
        System.out.println(numbers);
    }

    // 당첨 개수 반환
    public Integer compareLotto(List<Integer> targetLotto){
        HashSet<Integer> lottoSet=new HashSet<>(numbers);
        HashSet<Integer> targetLottoSet=new HashSet<>(targetLotto);

        lottoSet.retainAll(targetLottoSet);
        return lottoSet.size();
    }

    // 보너스 번호 추가 검증
    public Boolean compareBonus(Integer targetNumber){
        for(Integer number:numbers){
            if (number==targetNumber){
                return true;
            }
        }
        return false;
    }






}
