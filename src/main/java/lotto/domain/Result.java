package lotto.domain;

import java.util.EnumMap;

public class Result {

    private final EnumMap<Status,Integer> result = new EnumMap<>(Status.class);

    private Result() {}

    public static Result of(){
        Result r=new Result();
        for (Status status:Status.values()){
            r.result.put(status,r.result.getOrDefault(status,0));
        }
        return r;
    }

    public void add(Status status){
        result.put(status,result.getOrDefault(status,0)+1);
    }

    public EnumMap<Status, Integer> getResult() {
        return result;
    }

    public double calculateReturn(int amount){
        int total=0;
        for (Status status:Status.values()){
            total+=result.get(status)* status.getPrice();
        }
        return total/amount;
    }


}
