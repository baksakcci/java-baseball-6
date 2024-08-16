package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.umpire.Umpire;
import baseball.model.umpire.UmpireImpl;
import baseball.model.vo.BaseballNumber;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class UmpireTest {

    private final Umpire umpire;

    public UmpireTest() {
        this.umpire = new UmpireImpl();
    }

    @Test
    void 볼_갯수_계산하기() {
        // given
        BaseballNumber pitcher = BaseballNumber.of("123");
        BaseballNumber hitter = BaseballNumber.of("312");
        int strike = umpire.determineStrike(pitcher, hitter);

        // when
        int ball = umpire.determineBall(pitcher, hitter, strike);

        // then
        assertThat(ball).isEqualTo(3);
    }

    @Test
    void 스트라이크_갯수_계산하기() {
        // given
        BaseballNumber pitcher = BaseballNumber.of("123");
        BaseballNumber hitter = BaseballNumber.of("124");

        // when
        int strike = umpire.determineStrike(pitcher, hitter);

        // then
        assertThat(strike).isEqualTo(2);
    }
}
