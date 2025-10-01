package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.dto.RequestDTO;
import lotto.dto.ResponseDTO;

public class LottoService {

    public ResponseDTO generateLotto(RequestDTO request){
        int count = request.price() / 1000;
        List<List<Integer>> lotto = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            lotto.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return new ResponseDTO(count, lotto);
    }

}
