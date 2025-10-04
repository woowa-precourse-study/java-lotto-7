package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ApplicationStarter {

    public void start() {
        LottoController controller = new LottoController(
                new LottoService(),
                new InputView(),
                new OutputView()
        );
        controller.run();
    }
}
