package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.Validator;
import lotto.utils.Parser;

import java.util.ArrayList;
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

    public List<Integer> readLotto(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = readInput(List.of(
                Validator::validateNotBlank
        ));

        List<String> parsed=Parser.splitBy(input,",");
        List<Integer> result=new ArrayList<>();
        for (String p:parsed){
            result.add(Validator.validateIsNumber(p));
        }
        return result;

    }
    public int readBonus(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = readInput(List.of(
                Validator::validateNotBlank,
                Validator::validateRange
        ));
        return Integer.parseInt(input);
    }

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
