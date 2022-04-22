package racingcar.view;

import java.util.List;

import racingcar.common.GameConfig;
import racingcar.common.Message;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    public static void printInputErrorMessage(IllegalArgumentException e) {
        System.out.println(e);
    }

    public static void printRoundResult() {
        System.out.println("\n" + Message.ROUND_RESULT);
    }

    public static void printRaceRound(Cars cars) {
        List<Car> carList = cars.getCarList();
        for (int idx = 0; idx < carList.size(); idx++) {
            System.out.println(carList.get(idx).getName() + " : " + printMoveDistance(carList.get(idx)));
        }
        System.out.println();
    }

    private static String printMoveDistance(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < car.getPosition(); idx++) {
            sb.append(GameConfig.MOVE_DISPLAY);
        }
        return sb.toString();
    }
}
