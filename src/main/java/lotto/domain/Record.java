package lotto.domain;

import java.util.HashMap;

public class Record {
    private HashMap<Rank,Integer> rankRecord;

    public Record(){
        rankRecord=new HashMap<>();
        for (Rank rank: Rank.values()){
            rankRecord.put(rank,0);
        }
    }

    public void updateRecord(String rankString){
        // rankString이 enum 과 일치하는지 예외처리 필요
        Rank rank=Rank.valueOf(rankString);
        rankRecord.put(rank,rankRecord.get(rank)+1);
    }

    public void printRecord(){

    }
}

