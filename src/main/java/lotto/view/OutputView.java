package lotto.view;

import java.util.List;
import lotto.dto.ProfitResponseDTO;
import lotto.dto.ResponseDTO;
import lotto.util.Win;

public class OutputView {

    public static void printLotto(ResponseDTO response){
        System.out.println(response.count() + "개 를 구매했습니다." );
        for(List<Integer> lotto : response.lotto()){
            System.out.println(lotto);
        }
    }

    public static void printProfit(ProfitResponseDTO response){
        System.out.println("당첨 통계");
        System.out.println("---");
        for(int i = 3; i <= 6; i++){
            System.out.println(i + "개 일치 (" + Win.values()[i-3].getValue()+") - " + response.matchCount().get(i) + "개");
        }
    }


}
