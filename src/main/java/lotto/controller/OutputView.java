package lotto.controller;


import lotto.domain.Lotto;
import lotto.domain.Status;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;

public class OutputView {
    public static void printLotto(int amount, List<Lotto> lottoGroup){
        System.out.println(amount+"개를 구매했습니다.");
        for (Lotto lotto:lottoGroup){
            lotto.getNumbers().stream().sorted();
            System.out.println(String.join(", ", lotto.getNumbers().toString()));
        }
    }

    public static  void printMatch(EnumMap<Status,Integer> result){
        for (Status status:result.keySet()){
            if (status==Status.NONE){
                continue;
            }
            DecimalFormat df = new DecimalFormat("###,###");
            String money = df.format(status.getPrice());
            System.out.printf("%s (%s원) - %d개\n",status.getMessage(),money,result.getOrDefault(status,0));
        }
    }

    public static void printReturn(double benefit){
        System.out.println(String.format("총 수익률은 %.2f입니다.",benefit));
    }
}

