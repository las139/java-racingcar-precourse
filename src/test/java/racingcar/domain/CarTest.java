package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import racingcar.common.GameConfig;

public class CarTest {
    @Test
    @DisplayName("랜덤숫자_생성_범위_0_9_체크")
    @RepeatedTest(1000)
    void 랜덤숫자_생성_범위_0_9_체크() {
        Car car = new Car("pobi", GameConfig.CAR_BASE_POSITION);
        int no = car.generateRandomNo(GameConfig.MIN_RANDOM_NO, GameConfig.MAX_RANDOM_NO);
        assertThat(no).isBetween(GameConfig.MIN_RANDOM_NO, GameConfig.MAX_RANDOM_NO);
    }

    @ParameterizedTest
    @DisplayName("랜덤값_4_미만_자동차_이동_체크")
    @ValueSource(ints = { 0, 1, 2, 3 })
    void 랜덤값_4_미만_자동차_이동_체크(int no) {
        Car car = new Car("pobi", GameConfig.CAR_BASE_POSITION);
        assertThat(car.isGo(no)).isFalse();
    }

    @ParameterizedTest
    @DisplayName("랜덤값_4_이상_자동차_이동_체크")
    @ValueSource(ints = { 4, 5, 6, 7, 8, 9 })
    void 랜덤값_4_이상_자동차_이동_체크(int no) {
        Car car = new Car("pobi", GameConfig.CAR_BASE_POSITION);
        assertThat(car.isGo(no)).isTrue();
    }
}
