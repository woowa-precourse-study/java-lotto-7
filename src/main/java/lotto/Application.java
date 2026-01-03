package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;

public class Application {

    public static void main(String[] args) {
        LottoService service = new LottoService();
        LottoController controller = new LottoController(service);
        try {
            controller.run();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}

