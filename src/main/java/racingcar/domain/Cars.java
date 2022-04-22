package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = new ArrayList<Car>();
        for (Car car : carList) {
            this.carList.add(car);
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public void move() {
        carList.forEach(Car::move);
    }

    public List<Car> winnerList() {
        List<Car> winnerList = new ArrayList<Car>();
        int maxPosition = Collections.max(carList).getPosition();
        for (Car car : carList) {
            addWinnerCar(winnerList, car, maxPosition);
        }
        return winnerList;
    }

    public void addWinnerCar(List<Car> winnerList, Car car, int maxPosition) {
        if (car.isEqualPosition(maxPosition)) {
            winnerList.add(car);
        }
    }
}
