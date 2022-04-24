package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racingcar.common.GameConfig;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceGame {

    public void start() {
        Cars carList = inputCarName();
        TryCount tryCount = inputTryCount();
        startRace(carList, tryCount);
        result(carList);
    }

    private Cars inputCarName() {
        String input = InputView.inputCarNameView();
        try {
            return new Cars(input);
        } catch (IllegalArgumentException e) {
            OutputView.printInputErrorMessage(e);
            return inputCarName();
        }
    }

    private TryCount inputTryCount() {
        String input = InputView.inputTryCountView();
        try {
            return new TryCount(input);
        } catch (IllegalArgumentException e) {
            OutputView.printInputErrorMessage(e);
            return inputTryCount();
        }
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

    public void startRace(Cars cars, TryCount tryCount) {
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
