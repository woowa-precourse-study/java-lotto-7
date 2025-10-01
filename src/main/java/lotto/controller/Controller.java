package lotto.controller;

import lotto.dto.RequestDTO;
import lotto.dto.ResponseDTO;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    public void LottoController() {
        RequestDTO request = InputView.getInput();
        LottoService lottoService = new LottoService();
        ResponseDTO lotto = lottoService.generateLotto(request);
        OutputView.printLotto(lotto);
    }
}
