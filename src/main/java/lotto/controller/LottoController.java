package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Record;
import lotto.exception.Validator;
import lotto.service.LottoService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private final Integer lottoPrice=1000;  // 로또 금액
    // Controller 메인 함수
    public void doLotto(LottoService lottoService){
        Boolean flag=false;
        String input="";
        lotto.domain.Record record=new Record();

        while(!flag){
            outputMessage(Message.REQUEST_PRICE_TO_PAY);
            input=inputMessage();
            flag=Validator.checkPrice(input);
        }
        Integer price=Integer.parseInt(input);

        Integer lottoCount=price/lottoPrice;
        outputMessage(String.format(Message.PRINT_THE_NUMBER_OF_LOTTO,lottoCount));


        flag=false;
        while(!flag){
            outputMessage(Message.REQUEST_TARGET_NUMBER);
            input=inputMessage();
            flag=Validator.checkLottoNumber(input);
        }

        List<Integer> targetNumbers= Arrays.stream(input.split(","))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList());

        flag=false;
        while(!flag){
            outputMessage(Message.REQUEST_BONUS_NUMBER);
            input=inputMessage();
            flag=Validator.checkBonusNumber(input);
        }
        Integer bonusNumber=Integer.parseInt(input);

        lottoService.playLotto(lottoCount,targetNumbers,bonusNumber,record);
        System.out.println(Message.LOTTO_RESULT);
        record.printRecord();
        String returnPercent=record.getReturnPercent(price);
        System.out.println(String.format(Message.LOTTO_RESULT_TOTAL,returnPercent));




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



