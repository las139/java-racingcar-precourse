package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int generateRandomNo(int startNo, int endNo) {
        return Randoms.pickNumberInRange(startNo, endNo);
    }
}
