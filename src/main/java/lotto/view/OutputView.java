package lotto.view;

import lotto.constant.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoResult;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    private static final String LOTTO_LIST_PRINT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String STATISTICS_MESSAGE = "\n당첨 통계\n---";
    private static final String SECOND_MESSAGE = "%s개 일치, 보너스 볼 일치 (%s원) - %s개\n";
    private static final String OTHER_RANK_MESSAGE = "%s개 일치 (%s원) - %s개\n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    DecimalFormat df = new DecimalFormat("###,###");

    public void printLottoList(LottoList lottoList) {
        System.out.printf(LOTTO_LIST_PRINT_MESSAGE, lottoList.getLottoCount());
        for (Lotto lotto : lottoList.getLottoList()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println(STATISTICS_MESSAGE);
        Map<Rank, Integer> matchedCount = lottoResult.getMatchedCount();
        for (Rank rank : matchedCount.keySet()) {
            if (rank == Rank.SECOND) {
                System.out.printf(SECOND_MESSAGE,
                        rank.getMatchingCount(),
                        df.format(rank.getPrize()),
                        matchedCount.get(rank)
                );
                continue;
            }

            System.out.printf(OTHER_RANK_MESSAGE,
                    rank.getMatchingCount(),
                    df.format(rank.getPrize()),
                    matchedCount.get(rank)
            );
        }
        System.out.printf(PROFIT_RATE_MESSAGE, lottoResult.getProfitRate());
    }
}
