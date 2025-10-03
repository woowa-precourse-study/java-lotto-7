package lotto.controller;

import lotto.domain.LottoList;
import lotto.domain.LottoResult;
import lotto.domain.WinningNumber;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService service;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService service, InputView inputView, OutputView outputView) {
        this.service = service;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String inputPurchaseAmount;
        String inputWinningNumber;
        String inputBonusNumber;
        LottoList lottoList;
        WinningNumber winningNumber;
        boolean isNull;

        do {
            inputPurchaseAmount = inputView.readPurchaseAmount();
            lottoList = service.getLottoList(inputPurchaseAmount);
        } while (lottoList == null);

        outputView.printLottoList(lottoList);

        do {
            inputWinningNumber = inputView.readWinningNumber();
            winningNumber = service.getWinningNUmber(inputWinningNumber);
        } while (winningNumber == null);

        do {
            inputBonusNumber = inputView.readBonusNumber();
            isNull = service.getWinningNumberWithBonusNumber(winningNumber, inputBonusNumber);
        } while (!isNull);

        LottoResult lottoResult = service.getLottoResult(winningNumber, lottoList);
        outputView.printLottoResult(lottoResult);
    }
}
