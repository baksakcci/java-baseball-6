package baseball.fixture;

import baseball.model.vo.BaseballNumber;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("NonAsciiCharacters")
public class BaseballNumberFixture {

    public static List<Integer> 숫자_4자리_생성() {
        return new ArrayList<>(){{add(1); add(2); add(3); add(4);}};
    }

    public static List<Integer> 숫자_첫째_셋째_중복_생성() {
        return new ArrayList<>(){{add(1); add(3); add(1);}};
    }

    public static List<Integer> 숫자_0포함_생성() {
        return new ArrayList<>(){{add(1); add(2); add(0);}};
    }

    public static BaseballNumber 야구숫자_생성(int... num) {
        return BaseballNumber.of(new ArrayList<>(){{add(num[0]); add(num[1]); add(num[2]);}});
    }

}
