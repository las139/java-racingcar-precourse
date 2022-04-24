package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.common.Message;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryCountTest {
    @ParameterizedTest
    @DisplayName("시도횟수_입력_자연수_체크")
    @ValueSource(strings = { "a", "0", "-1" })
    void 시도횟수_입력_자연수_체크(String tryCount) {
        assertThatThrownBy(() -> {
            new TryCount(tryCount);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Message.ERROR_TRY_COUNT_NOT_NUMBER);
    }
}
