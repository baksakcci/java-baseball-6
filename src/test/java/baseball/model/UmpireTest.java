package baseball.model;

import static baseball.fixture.BaseballNumberFixture.*;
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
        BaseballNumber 투수 = 야구숫자_생성(1, 2, 3);
        BaseballNumber 타자 = 야구숫자_생성(3, 1, 2);
        int 스트라이크_갯수 = umpire.determineStrike(투수, 타자);

        // when
        int 볼_개수 = umpire.determineBall(투수, 타자, 스트라이크_갯수);

        // then
        assertThat(볼_개수).isEqualTo(3);
    }

    @Test
    void 스트라이크_갯수_계산하기() {
        // given
        BaseballNumber 투수 = 야구숫자_생성(1, 2, 3);
        BaseballNumber 타자 = 야구숫자_생성(1, 2, 4);

        // when
        int 스트라이크_갯수 = umpire.determineStrike(투수, 타자);

        // then
        assertThat(스트라이크_갯수).isEqualTo(2);
    }
}
