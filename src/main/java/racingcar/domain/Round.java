package racingcar.domain;

public class Round {
    private int roundCount;

    public Round(int roundCount) {
        this.roundCount = roundCount;
    }

    public boolean isGameEnd(int tryCount) {
        return roundCount == tryCount;
    }

    public void playedRound() {
        roundCount++;
    }
}
