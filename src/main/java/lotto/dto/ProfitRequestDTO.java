package lotto.dto;

import java.util.List;

public record ProfitRequestDTO(
        List<Integer> numbers,
        int bonusNumber
) {

}
