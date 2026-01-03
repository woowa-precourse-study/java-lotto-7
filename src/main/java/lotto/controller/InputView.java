package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.Validator;

import java.util.List;
import java.util.NoSuchElementException;

public class InputView {

    public int readMessage() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readInput(List.of(
                Validator::validateNotBlank,
                Validator::validatePrice

        ));
        return Integer.parseInt(input);
    }

//    public List<Integer> readLotto(){
//
//    }

    private String readInput(List<Validator> validators) {
        try{
            String input = Console.readLine().trim();
            for (Validator v : validators) {
                v.validate(input);
            }
            return input;
        } catch(NoSuchElementException e){
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }

    }
}
