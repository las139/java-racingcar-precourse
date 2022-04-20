package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.common.GameConfig;
import racingcar.common.Message;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

class ValidationUtilsTest {
    @ParameterizedTest
    @DisplayName("자동차_이름_입력_갯수_체크")
    @ValueSource(strings = { "pobi", "crong", "pobi," })
    void 자동차_이름_입력_갯수_체크(String carNames) {
        List<String> carList = Arrays.asList(carNames.split(GameConfig.CAR_NAME_SEPERATOR));
        assertThatThrownBy(() -> {
            ValidationUtils.carNameCountChk(carList);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_MIN_CAR_COUNT);
    }

    @ParameterizedTest
    @DisplayName("자동차_이름_중복_체크")
    @ValueSource(strings = { "pobi,crong,pobi,honux", "joseh,suara,doyoti,suara" })
    void 자동차_이름_중복_체크(String carNames) {
        List<String> carList = Arrays.asList(carNames.split(GameConfig.CAR_NAME_SEPERATOR));
        assertThatThrownBy(() -> {
            ValidationUtils.carNameUniqueChk(carList);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_CAR_NOT_UNIQUE);
    }

    @ParameterizedTest
    @DisplayName("자동차_이름_공백_체크")
    @ValueSource(strings = { "", " ", "    " })
    void 자동차_이름_공백_체크(String carName) {
        assertThatThrownBy(() -> {
            ValidationUtils.carNameEmptyChk(carName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_CAR_NAME_EMPTY);
    }

    @ParameterizedTest
    @DisplayName("자동차_이름_길이_체크")
    @ValueSource(strings = { "pobise", "wonini", "joseph", "toyotiiii" })
    void 자동차_이름_길이_체크(String carName) {
        assertThatThrownBy(() -> {
            ValidationUtils.carNameLengthChk(carName);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_CAR_NAME_LENGTH);
    }

    @ParameterizedTest
    @DisplayName("시도횟수_입력_자연수_체크")
    @ValueSource(strings = { "a", "0", "-1" })
    void 시도횟수_입력_자연수_체크(String tryCount) {
        assertThatThrownBy(() -> {
            ValidationUtils.tryCountChk(tryCount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_TRY_COUNT_NOT_NUMBER);
    }
}
