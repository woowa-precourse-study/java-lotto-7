package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.RequestDTO;

public class LottoService {

    public void temp(RequestDTO requestDto){
        Lotto lotto = new Lotto(requestDto.getTargetNumbers());

    }

}
