package lotto.random;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomGenerator {
    public static List<Integer> generateRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
