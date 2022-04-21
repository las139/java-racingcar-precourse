package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

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
}
