package lotto.domain;

import lotto.constant.Rank;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class LottoResult {
    private final Map<Rank, Integer> matchedCount = new TreeMap<>(Comparator.comparing(Rank::getRank).reversed());
    private double profitRate;

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            matchedCount.put(rank, 0);
        }
    }

    public Map<Rank, Integer> getMatchedCount() {
        return matchedCount;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public void confirmRank(WinningNumber winningNumber, LottoList lottoList) {
        for (Lotto lotto : lottoList.getLottoList()) {
            Rank rank = winningNumber.getRank(lotto);
            if (rank != null) {
                matchedCount.put(rank, matchedCount.getOrDefault(rank, 0) + 1);
            }
        }
    }

    public void calculateProfitRate(LottoList lottoList) {
        int purchaseAmount = lottoList.getLottoCount() * 1000;
        int profit = 0;
        for (Rank rank : matchedCount.keySet()) {
            profit += rank.getPrize() * matchedCount.get(rank);
        }
        profitRate = (double) profit / purchaseAmount * 100;
    }
}
