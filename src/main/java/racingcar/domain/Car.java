package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.GameConfig;

public class Car implements Comparable<Car> {
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
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

    public boolean isEqualPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    @Override
    public int compareTo(Car car) {
        return this.position > car.getPosition() ? 1 : -1;
    }
}
