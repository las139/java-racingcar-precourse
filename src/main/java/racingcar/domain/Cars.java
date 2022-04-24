package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import racingcar.common.GameConfig;
import racingcar.common.Message;

public class Cars {
    private List<Car> carList;

    public Cars(String carNames) {
        List<String> carNameList = Arrays.asList(carNames.split(GameConfig.CAR_NAME_SEPERATOR));
        validateCount(carNameList);
        validateDuplicate(carNameList);
        this.carList = mapCars(carNameList);
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    private boolean validateCount(List<String> carNameList) {
        if (carNameList.size() < GameConfig.MIN_CAR_COUNT) {
            throw new IllegalArgumentException(Message.ERROR_MIN_CAR_COUNT);
        }
        return true;
    }

    private boolean validateDuplicate(List<String> carNameList) {
        HashSet<String> carNameSet = new HashSet<String>(carNameList);
        if (carNameList.size() != carNameSet.size()) {
            throw new IllegalArgumentException(Message.ERROR_CAR_NOT_UNIQUE);
        }
        return true;
    }

    public List<Car> mapCars(List<String> carNameList) {
        List<Car> carList = new ArrayList<Car>();
        for (String carName : carNameList) {
            Car car = new Car(carName, GameConfig.BASE_CAR_POSITION);
            carList.add(car);
        }
        return carList;
    }

    public void move() {
        carList.forEach(Car::move);
    }

    public List<Car> winnerList() {
        List<Car> winnerList = new ArrayList<Car>();
        Position maxPosition = Collections.max(carList).getPosition();
        for (Car car : carList) {
            addWinnerCar(winnerList, car, maxPosition);
        }
        return winnerList;
    }

    public void addWinnerCar(List<Car> winnerList, Car car, Position maxPosition) {
        if (car.getPosition().isEqualPosition(maxPosition)) {
            winnerList.add(car);
        }
    }
}
