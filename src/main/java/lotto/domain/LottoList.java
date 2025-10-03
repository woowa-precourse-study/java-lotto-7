package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private final List<Lotto> lottoList;

    private LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static LottoList of() {
        return new LottoList(new ArrayList<>());
    }

    public void add(Lotto lotto) {
        lottoList.add(lotto);
    }

    public int getLottoCount() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
