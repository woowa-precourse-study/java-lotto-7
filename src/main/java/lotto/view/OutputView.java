package lotto.view;

import java.util.List;
import lotto.dto.ResponseDTO;

public class OutputView {

    public static void printLotto(ResponseDTO response){
        System.out.println(response.count() + "개 를 구매했습니다." );
        for(List<Integer> lotto : response.lotto()){
            System.out.println(lotto);
        }
    }

}
