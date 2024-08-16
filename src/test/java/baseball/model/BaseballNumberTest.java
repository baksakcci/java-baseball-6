package baseball.model;

import static baseball.fixture.BaseballNumberFixture.숫자_0포함_생성;
import static baseball.fixture.BaseballNumberFixture.숫자_4자리_생성;
import static baseball.fixture.BaseballNumberFixture.숫자_첫째_셋째_중복_생성;
import static baseball.fixture.BaseballNumberFixture.야구숫자_생성;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.model.vo.BaseballNumber;
import java.util.List;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class BaseballNumberTest {

    @Test
    void 숫자에_0을_포함할_경우_예외_발생() {
        // given
        List<Integer> 숫자_0포함 = 숫자_0포함_생성();

        // when & then
        assertThatThrownBy(() -> BaseballNumber.of(숫자_0포함))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_3자리가_아닐_경우_예외_발생() {
        // given
        List<Integer> 숫자_4자리 = 숫자_4자리_생성();

        // when & then
        assertThatThrownBy(() -> BaseballNumber.of(숫자_4자리))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 각_숫자마다_중복이_있을_경우_예외_발생() {
        // given
        List<Integer> 숫자_첫째_셋째_중복 = 숫자_첫째_셋째_중복_생성();

        // when & then
        assertThatThrownBy(() -> BaseballNumber.of(숫자_첫째_셋째_중복))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 불변성_테스트하기() {
        // given
        BaseballNumber 숫자_1 = 야구숫자_생성(1, 2, 3);
        BaseballNumber 숫자_2 = 야구숫자_생성(1, 2, 3);

        // when & then
        assertThat(숫자_1.equals(숫자_2)).isTrue();
        assertThat(숫자_1.hashCode()).isEqualTo(숫자_2.hashCode());
    }
}
