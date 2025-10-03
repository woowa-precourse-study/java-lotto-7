package lotto.controller;

import lotto.dto.LottoRequestDTO;
import lotto.dto.ProfitRequestDTO;
import lotto.dto.ProfitResponseDTO;
import lotto.dto.ResponseDTO;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    public void LottoController() {
        LottoRequestDTO request = InputView.inputPrice();
        LottoService lottoService = new LottoService();
        ResponseDTO lotto = lottoService.generateLotto(request);
        OutputView.printLotto(lotto);
        ProfitRequestDTO profitRequest = InputView.inputNumbers();
        ProfitResponseDTO profit = lottoService.calculateProfit(lotto.lotto(), profitRequest);
        OutputView.printProfit(profit);
    }


}
