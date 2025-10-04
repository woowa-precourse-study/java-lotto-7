package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Record;

import java.util.HashSet;
import java.util.List;

public class LottoService {

    public void playLotto(Integer lottoCount,List<Integer> targetNumbers,Integer bonusNumber){
        Record record=new Record();
        String rank="";
        for(int i=0;i<lottoCount;i++){
            Integer count=0;
            List<Integer> randomNumbers=getRandomNumbers();
            Lotto lotto=new Lotto(randomNumbers);
            lotto.printNumbers();
            count=lotto.compareLotto(targetNumbers);

            // 보너스 번호 추가 검증
            Boolean flag=lotto.compareBonus(bonusNumber);
            if (flag==true){
                count+=1;
            }
            if (count>=3){
                rank=getrank(flag,count);
                record.updateRecord(rank);
            }

        }

        System.out.println("수익률 계산");

    }

    // 랜덤 수
    // 랜덤한 6개의 수 추출
    private List<Integer> getRandomNumbers(){
        List<Integer> randomNumbers= Randoms.pickUniqueNumbersInRange(1,45,6);
        return randomNumbers;
    }

    private String getrank(Boolean flag,Integer count){
        String rank="RANK_";
        rank+=count;
        if (count==5 || flag==false){
            rank+="b";
        }
        return rank;
    }


    // 수익률을 계산한다


}
