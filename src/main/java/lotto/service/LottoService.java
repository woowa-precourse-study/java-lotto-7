package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.LottoRequestDTO;
import lotto.dto.ProfitRequestDTO;
import lotto.dto.ProfitResponseDTO;
import lotto.dto.ResponseDTO;

public class LottoService {

    public ResponseDTO generateLotto(LottoRequestDTO request){
        int count = request.price() / 1000;
        List<List<Integer>> lotto = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            lotto.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return new ResponseDTO(count, lotto);
    }

    public ProfitResponseDTO calculateProfit(List<List<Integer>> lotto, ProfitRequestDTO request){
        Lotto lottoClass = new Lotto(request.numbers());
        List<Integer> checkResult = lottoClass.checkLottos(lotto);
        List<Integer> matchCount = new ArrayList<>(Collections.nCopies(7,0));
        for(int i = 0; i < checkResult.size(); i++){
            int rank = checkResult.get(i);
            matchCount.set(rank, matchCount.get(rank) + 1);
        }
        return new ProfitResponseDTO(matchCount);
    }
}
