package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.Message;
import racingcar.utils.ValidationUtils;

public class InputView {
    public static String inputCarNameView() {
        System.out.println(Message.CAR_NAME_INPUT);
        String carNames = Console.readLine();
        try {
            ValidationUtils.carNameAllChk(carNames);
        } catch (IllegalArgumentException e) {
            OutputView.printInputErrorMessage(e);
            inputCarNameView();
        }
        return carNames;
    }

    public static String inputTryCountView() {
        System.out.println(Message.TRY_COUNT_INPUT);
        String tryCount = Console.readLine();
        try {
            ValidationUtils.tryCountChk(tryCount);
        } catch (IllegalArgumentException e) {
            OutputView.printInputErrorMessage(e);
            inputTryCountView();
        }
        return tryCount;
    }
}