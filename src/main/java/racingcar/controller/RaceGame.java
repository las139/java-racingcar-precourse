package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingcar.common.GameConfig;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.utils.ValidationUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceGame {

    public void start() {
        String carNames = inputCarName();
        int tryCount = Integer.parseInt(inputTryCount());

        List<Car> carList = stringToCarList(carNames);
        Cars cars = new Cars(carList);
        startRace(cars, tryCount);
        result(cars);
    }

    private String inputCarName() {
        String carName = InputView.inputCarNameView();
        try {
            ValidationUtils.carNameAllChk(carName);
        } catch (IllegalArgumentException e) {
            OutputView.printInputErrorMessage(e);
            inputCarName();
        }
        return carName;
    }

    private String inputTryCount() {
        String tryCount = InputView.inputTryCountView();
        try {
            ValidationUtils.tryCountChk(tryCount);
        } catch (IllegalArgumentException e) {
            OutputView.printInputErrorMessage(e);
            inputTryCount();
        }
        return tryCount;
    }

    public List<Car> stringToCarList(String carNames) {
        List<String> carNameList = Arrays.asList(carNames.split(GameConfig.CAR_NAME_SEPERATOR));
        List<Car> carList = new ArrayList<Car>();
        for (String carName : carNameList) {
            Car car = new Car(carName, GameConfig.BASE_CAR_POSITION);
            carList.add(car);
        }
        return carList;
    }

    public void startRace(Cars cars, int tryCount) {
        OutputView.printRoundResult();
        Round round = new Round(GameConfig.BASE_ROUND_COUNT);
        while (!round.isGameEnd(tryCount)) {
            cars.move();
            round.playedRound();
            OutputView.printRaceRound(cars);
        }
    }

    public void result(Cars cars) {
        List<Car> winnerList = cars.winnerList();
        OutputView.printFinalWinner(winnerList);
    }
}
