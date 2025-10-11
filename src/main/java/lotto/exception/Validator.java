package lotto.exception;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    // 로또 구매 금액 검증
    public static boolean checkPrice(String price) {
        try{
            checkBlank(price);
            checkNumberIsInteger(price);
            checkPriceUnit(price);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    // 로또 번호 검증
    public static Boolean checkLottoNumber(String input){
        checkBlank(input);
        String[] numbers=input.split(",");
        try{
            checkNumberLength(numbers);
            for(String number:numbers){
                checkNumberIsInteger(number);
                checkNumberInRange(number);
            }
            checkNumberUnique(numbers);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    // 보너스 번호 검증
    public static boolean checkBonusNumber(String number){
        try {
            checkBlank(number);
            checkNumberIsInteger(number);
            checkNumberInRange(number);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    // 빈 문자열인지 검증
    public static void checkBlank(String InputString){
        if (InputString.length()<1){
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    // 금액이 1000단위인지 검증
    public static void checkPriceUnit(String price) {
        if (Integer.parseInt(price)%1000!=0){
            throw new IllegalArgumentException(ErrorMessage.INVALID_PRICE.getMessage());
        }
    }

    // 로또 번호 길이 6개인지 검증
    public static void checkNumberLength(String[] numbers){
        if (numbers.length!=6){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_LENGTH.getMessage());
        }
    }

    // 1~45 사이 숫자인지 검증
    public static void checkNumberInRange(String number){
        int num=Integer.parseInt(number);
        if (num<1||num>45){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    // 숫자인지 검증
    public static void checkNumberIsInteger(String number){
        try {
            Integer.parseInt(number);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_NUMBER.getMessage());
        }
    }


    // 로또 번호 중복인지 검증
    public static void checkNumberUnique(String[] numbers){
        Set<String> numberSet=new HashSet<>(Arrays.asList(numbers));
        if (numberSet.size()!=numbers.length){
            throw new IllegalArgumentException(ErrorMessage.NOT_UNIQUE_NUMBER.getMessage());
        }
    }



}
