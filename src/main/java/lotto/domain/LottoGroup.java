package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {
    private final List<Lotto> lottoGroup = new ArrayList<>();

    public LottoGroup() {}

    public void add(Lotto lotto){
        lottoGroup.add(lotto);
    }

    public List<Lotto> getLottoGroup() {
        return lottoGroup;
    }


}
