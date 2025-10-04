package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private final Integer lottoPrice=1000;  // 로또 금액

    // Controller 메인 함수
    public void doLotto(){

        outputMessage(Message.REQUEST_PRICE_TO_PAY);
        Integer price=Integer.parseInt((inputMessage()));

        Integer lottoCount=price/lottoPrice;

        outputMessage(String.format(Message.PRINT_THE_NUMBER_OF_LOTTO,lottoCount));

        outputMessage(Message.REQUEST_TARGET_NUMBER);

        List<Integer> TargetNumbers= Arrays.stream(inputMessage().split(","))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList());
        System.out.println(TargetNumbers);
        outputMessage(Message.REQUEST_BONUS_NUMBER);
        Integer BonusNumber=Integer.parseInt((inputMessage()));


    }


    // 메세지 출력
    public void outputMessage(String message){
        System.out.println(message);
    }

    // 사용자에게 입력 받음
    public String inputMessage(){
        String inputString=Console.readLine();
        return inputString;
    }
}



