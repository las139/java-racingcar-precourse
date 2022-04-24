package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.common.GameConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {
    @ParameterizedTest
    @DisplayName("게임_종료_체크")
    @ValueSource(strings = { "1", "2", "3", "4", "5" })
    void 게임_종료_체크(String number) {
        Round round = new Round(GameConfig.BASE_ROUND_COUNT);
        TryCount tryCount = new TryCount(number);
        for (int count = 0; count < tryCount.getTryCount(); count++) {
            round.playedRound();
        }
        assertThat(round.isGameEnd(tryCount)).isTrue();
    }
}
