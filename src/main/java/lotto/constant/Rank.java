package lotto.constant;

public enum Rank {
    FIRST(1, 2000000000, 6),
    SECOND(2, 30000000, 5),
    THIRD(3, 1500000, 5),
    FOURTH(4, 50000, 4),
    FIFTH(5, 5000, 3);

    Rank(Integer rank, int prize, int matchingCount) {
        this.rank = rank;
        this.prize = prize;
        this.matchingCount = matchingCount;
    }

    private final Integer rank;
    private final int prize;
    private final int matchingCount;

    public Integer getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }


}
