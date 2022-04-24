package racingcar.controller;

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
        Cars cars = inputCarName();
        TryCount tryCount = inputTryCount();
        startRace(cars, tryCount);
        result(cars);
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

    private void startRace(Cars cars, TryCount tryCount) {
        OutputView.printRoundResult();
        Round round = new Round(GameConfig.BASE_ROUND_COUNT);
        while (!round.isGameEnd(tryCount)) {
            cars.move();
            round.playedRound();
            OutputView.printRaceRound(cars);
        }
    }

    private void result(Cars cars) {
        List<Car> winnerList = cars.findWinners();
        OutputView.printFinalWinner(winnerList);
    }
}
