package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 범위를 넘어가면 예외가 발생한다.")
    @Test
    void 로또_번호가_범위를_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 로또_체크_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(6).isEqualTo(lotto.checkLotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 로또_체크_테스트2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(4).isEqualTo(lotto.checkLotto(List.of(1, 2, 12, 4, 5, 7)));
    }

    @Test
    void 로또_체크_테스트3() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(2).isEqualTo(lotto.checkLotto(List.of(24, 33, 12, 4, 5, 17)));
    }

    @Test
    void 로또_체크_테스트4() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(0).isEqualTo(lotto.checkLotto(List.of(24, 33, 12, 34, 25, 17)));
    }

    @Test
    void 로또_리스트_체크_테스트1() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<List<Integer>> inputLottos = List.of(
                List.of(1,22,33,44,15,16),
                List.of(1,2,33,44,15,16),
                List.of(1,2,3,44,15,16),
                List.of(1,2,3,4,15,16),
                List.of(1,2,3,4,5,16),
                List.of(1,2,3,4,5,6)
        );
        assertThat(List.of(1, 2, 3, 4, 5, 6)).isEqualTo(lotto.checkLottos(inputLottos));
    }


    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
