package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.GameConfig;

public class Car {
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        int no = generateRandomNo(GameConfig.MIN_RANDOM_NO, GameConfig.MAX_RANDOM_NO);
        if (isGo(no)) {
            position++;
        }
    }

    public boolean isGo(int no) {
        return no >= GameConfig.MOVE_CONDITION_NO;
    }

    public int generateRandomNo(int startNo, int endNo) {
        return Randoms.pickNumberInRange(startNo, endNo);
    }
}
