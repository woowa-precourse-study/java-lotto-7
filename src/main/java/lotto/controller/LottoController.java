package lotto.controller;

import lotto.service.LottoService;

import java.util.function.Supplier;

public class LottoController {
    private final InputView inputView;
    private final LottoService service;
    static final int MAX_RETRY = 10;

    public LottoController(LottoService service) {
        this.inputView = new InputView();
        this.service = service;
    }

    public void run() {

        int input = doRetry(
                inputView::readMessage,
                "[ERROR] 1000원 단위만 입력 가능합니다."
        );



    }

    private <T> T doRetry(Supplier<T> action, String errorMessage) {
        int retry = 0;
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                retry++;
                System.out.println(errorMessage);

                if (retry >= MAX_RETRY) {
                    throw new IllegalStateException("입력 횟수를 초과했습니다.");
                }
            }
        }
    }


}


