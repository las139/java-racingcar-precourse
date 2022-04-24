package racingcar.domain;

import racingcar.common.Message;

public class TryCount {
    private int tryCount;

    public TryCount(String tryCount) {
        validTryCount(tryCount);
        this.tryCount = Integer.parseInt(tryCount);
    }

    public int getTryCount() {
        return this.tryCount;
    }

    private void validTryCount(String tryCount) {
        if (!isNaturalNumber(tryCount)) {
            throw new IllegalArgumentException(Message.ERROR_TRY_COUNT_NOT_NUMBER);
        }
    }

    private boolean isNaturalNumber(String tryCount) {
        try {
            return Integer.parseInt(tryCount) > 0 ? true : false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
