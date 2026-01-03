package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoPolicy {
    private final Lotto answerLotto;
    private final int bonus;

    public LottoPolicy(Lotto lotto,int number) {
        this.answerLotto=lotto;
        this.bonus=number;
    }

    public int matchLotto(Lotto lotto){
        Set<Integer> answer= new HashSet<>(answerLotto.getNumbers());
        Set<Integer> user= new HashSet<>(lotto.getNumbers());
        answer.retainAll(user);
        return answer.size();
    }

    public boolean isMatchBonus(int num){
        return answerLotto.getNumbers().contains(num);
    }



}
