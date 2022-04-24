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
        List<Car> carList = cars.getCars();
        for (int idx = 0; idx < carList.size(); idx++) {
            System.out.println(carList.get(idx).getName().getName() + " : " + printMoveDistance(carList.get(idx)));
        }
        System.out.println();
    }

    private static String printMoveDistance(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < car.getPosition().getPosition(); idx++) {
            sb.append(GameConfig.MOVE_DISPLAY);
        }
        return sb.toString();
    }

    public static void printFinalWinner(List<Car> winners) {
        System.out.print(Message.FINAL_WINNER_PREFIX);
        for (int idx = 0; idx < winners.size(); idx++) {
            System.out.print(addSeperator(idx) + winners.get(idx).getName().getName());
        }
    }

    private static String addSeperator(int index) {
        if (index > 0) {
            return GameConfig.CAR_NAME_SEPERATOR + " ";
        }
        return "";
    }
}
