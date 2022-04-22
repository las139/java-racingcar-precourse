package racingcar.controller;

import java.util.Arrays;
import java.util.List;

import racingcar.common.GameConfig;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceGame {

    public void start() {
        String carNames = InputView.inputCarNameView();
        int tryCount = Integer.parseInt(InputView.inputTryCountView());

        List<String> carList = Arrays.asList(carNames.split(GameConfig.CAR_NAME_SEPERATOR));
        Cars cars = new Cars(carList);
        startRace(cars, tryCount);
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
}