package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;

public class Runner {

    public void run(LottoService lottoService){
        LottoController lottoController=new LottoController(lottoService);
        lottoController.doLotto();
    }
}
