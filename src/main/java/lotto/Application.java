package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService=new LottoService();
        Runner runner=new Runner();
        runner.run(lottoService);
    }
}
