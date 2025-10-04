package lotto.domain;

import lotto.controller.Message;

import java.util.HashMap;

public class Record {
    private HashMap<Rank,Integer> rankRecord;
    private Integer totalReturn;

    public Record(){
        rankRecord=new HashMap<>();
        totalReturn=0;
        for (Rank rank: Rank.values()){
            rankRecord.put(rank,0);
        }
    }

    public void updateRecord(String rankString){
        // rankString이 enum 과 일치하는지 예외처리 필요
        Rank rank=Rank.valueOf(rankString);
        rankRecord.put(rank,rankRecord.get(rank)+1);
        totalReturn+=rank.getAmount();
    }

    public void printRecord(){
        for (Rank rank: Rank.values()){
            System.out.println(String.format(Message.LOTTO_RESULT_DETAIL,rank.getDescription(),rankRecord.get(rank)));
        }
    }

    public String getReturnPercent(Integer price){
        return String.format("%.1f",(totalReturn/ (double)price)*100);
    }
}

