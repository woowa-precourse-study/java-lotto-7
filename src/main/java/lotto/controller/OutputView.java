package lotto.controller;


import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void printLotto(int amount, List<Lotto> lottoGroup){
        System.out.println(amount+"개를 구매했습니다.");
        for (Lotto lotto:lottoGroup){
            lotto.getNumbers().stream().sorted();
            System.out.println(String.join(", ", lotto.getNumbers().toString()));
        }
    }
}

