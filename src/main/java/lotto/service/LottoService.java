package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoResult;
import lotto.domain.WinningNumber;
import lotto.random.RandomGenerator;

import java.util.List;

import static lotto.util.Parser.*;
import static lotto.util.Validator.*;

public class LottoService {
    public LottoList getLottoList(String inputPurchaseAmount) {
        Integer purchaseAmount = parsePurchaseAmount(inputPurchaseAmount);
        if (purchaseAmount == null) return null;

        return generateLottoList(purchaseAmount);
    }

    private Integer parsePurchaseAmount(String inputPurchaseAmount) {
        int purchaseAmount;
        try {
            validateEmpty(inputPurchaseAmount);
            purchaseAmount = parseInt(inputPurchaseAmount);
            validatePositive(purchaseAmount);
            validateAmountOver(purchaseAmount);
            validateAmountUnit(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return purchaseAmount;
    }

    private LottoList generateLottoList(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;
        LottoList lottoList = LottoList.of();
        for (int i = 0; i < lottoCount; i++) {
            try {
                lottoList.add(new Lotto(RandomGenerator.generateRandomLottoNumber()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return lottoList;
    }


    public WinningNumber getWinningNUmber(String inputWinningNumber) {
        List<Integer> winningNumber = parseWinningNumber(inputWinningNumber);
        if (winningNumber == null) return null;

        return WinningNumber.getInstance(winningNumber);
    }

    private List<Integer> parseWinningNumber(String inputWinningNumber) {
        List<Integer> winningNumber;
        try {
            validateEmpty(inputWinningNumber);
            winningNumber = parseInt(split(inputWinningNumber));
            validateLottoNumberRange(winningNumber);
            validateWinningNumberCount(winningNumber);
            validateLottoNumberUnique(winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return winningNumber;
    }

    public boolean getWinningNumberWithBonusNumber(WinningNumber winningNumber, String inputBonusNumber) {
        int bonusNumber;
        try {
            validateEmpty(inputBonusNumber);
            bonusNumber = parseInt(inputBonusNumber);
            validateLottoNumberRange(bonusNumber);
            winningNumber.setBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public LottoResult getLottoResult(WinningNumber winningNumber, LottoList lottoList) {
        LottoResult lottoResult = new LottoResult();
        lottoResult.confirmRank(winningNumber, lottoList);
        lottoResult.calculateProfitRate(lottoList);

        return lottoResult;
    }
}
