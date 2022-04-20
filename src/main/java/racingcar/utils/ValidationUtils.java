package racingcar.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import racingcar.common.GameConfig;
import racingcar.common.Message;

public class ValidationUtils {
    public static boolean carNameAllChk(String carNames) {
        List<String> carList = splitStringToList(carNames, GameConfig.CAR_NAME_SEPERATOR);
        carNameCountChk(carList);
        carNameUniqueChk(carList);
        return true;
    }

    public static boolean carNameCountChk(List<String> carList) {
        if (carList.size() < GameConfig.MIN_CAR_COUNT) {
            throw new IllegalArgumentException(Message.ERROR_MIN_CAR_COUNT);
        }
        return true;
    }

    public static boolean carNameUniqueChk(List<String> carList) {
        HashSet<String> carSet = new HashSet<String>(carList);
        if (carList.size() != carSet.size()) {
            throw new IllegalArgumentException(Message.ERROR_CAR_NOT_UNIQUE);
        }
        return true;
    }

    public static boolean carNameEmptyChk(String carName) {
        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException(Message.ERROR_CAR_NAME_EMPTY);
        }
        return true;
    }

    public static boolean carNameLengthChk(String carName) {
        if (carName.length() > GameConfig.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(Message.ERROR_CAR_NAME_LENGTH);
        }
        return true;
    }

    public static List<String> splitStringToList(String carNames, String separator) {
        List<String> carList = new ArrayList<String>();
        for (String carName : carNames.split(separator)) {
            carNameEmptyChk(carName);
            carNameLengthChk(carName);
            carList.add(carName);
        }
        return carList;
    }

    public static boolean tryCountChk(String tryCount) {
        String regex = "^[1-9]*$";
        if (!tryCount.matches(regex)) {
            throw new IllegalArgumentException(Message.ERROR_TRY_COUNT_NOT_NUMBER);
        }
        return true;
    }
}
