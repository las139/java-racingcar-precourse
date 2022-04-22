package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.common.GameConfig;

public class Cars {
    private List<Car> carList;

    public Cars(List<String> carNameList) {
        carList = new ArrayList<Car>();
        for (String carName : carNameList) {
            Car car = new Car(carName, GameConfig.BASE_CAR_POSITION);
            this.carList.add(car);
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public void move() {
        carList.forEach(Car::move);
    }
}
