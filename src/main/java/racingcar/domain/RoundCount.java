package racingcar.domain;

public class RoundCount {
    private int roundCount;

    public RoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public int getRoundCount() {
        return this.roundCount;
    }

    public void addRoundCount() {
        this.roundCount++;
    }

    public boolean isEqualTryCount(TryCount tryCount) {
        return this.roundCount == tryCount.getTryCount();
    }
}
