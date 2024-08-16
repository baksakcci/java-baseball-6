package baseball.model.umpire;

import baseball.model.vo.BaseballNumber;

public interface Umpire {

    int determineStrike(BaseballNumber pitcher, BaseballNumber hitter);

    int determineBall(BaseballNumber pitcher, BaseballNumber hitter, int strike);

}
