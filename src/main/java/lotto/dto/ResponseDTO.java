package lotto.dto;

import java.util.List;

public record ResponseDTO(
        int count,
        List<List<Integer>> lotto
) {

}
