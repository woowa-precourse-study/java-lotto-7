package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoService;
import lotto.utils.RandomGenerator;

import java.util.List;
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
        LottoGroup lottoGroup = new LottoGroup();

        int input = doRetry(inputView::readMessage);

        int amount = input/1000;
        for(int i=0;i<amount;i++){
            lottoGroup.add(new Lotto(RandomGenerator.getRandomNumber()));
        }
        OutputView.printLotto(amount,lottoGroup.getLottoGroup());

        Lotto lotto = new Lotto(doRetry(inputView::readLotto));
        int bonus = doRetry(inputView::readBonus);

        LottoPolicy lottoPolicy=new LottoPolicy(lotto,bonus);
        Result result=Result.of();

        for(Lotto userLotto:lottoGroup.getLottoGroup()){
            int match=lottoPolicy.matchLotto(userLotto);
            boolean b=lottoPolicy.isMatchBonus(bonus);
            Status status=Status.fromMatch(match,b);
            result.add(status);
        }

        OutputView.printMatch(result.getResult());







    }

    private <T> T doRetry(Supplier<T> action) {
        int retry = 0;
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                retry++;
                System.out.println(e.getMessage());

                if (retry >= MAX_RETRY) {
                    throw new IllegalStateException("입력 횟수를 초과했습니다.");
                }
            }
        }
    }


}


