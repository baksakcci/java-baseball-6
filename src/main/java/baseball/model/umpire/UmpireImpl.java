package baseball.model.umpire;

import baseball.model.vo.BaseballNumber;
import java.util.List;
import java.util.stream.IntStream;

public class UmpireImpl implements Umpire {

    public int determineStrike(BaseballNumber pitcher, BaseballNumber hitter) {
        List<Integer> pitcherNumber = pitcher.getNumber();
        List<Integer> hitterNumber = hitter.getNumber();

        return (int) IntStream.range(0, 3)
                .filter(i -> pitcherNumber.get(i).equals(hitterNumber.get(i)))
                .count();
    }

    public int determineBall(BaseballNumber pitcher, BaseballNumber hitter, int strike) {
        List<Integer> pitcherNumber = pitcher.getNumber();
        List<Integer> hitterNumber = hitter.getNumber();

        return (int) IntStream.range(0, 3)
                .filter(i -> pitcherNumber.contains(hitterNumber.get(i)))
                .count()
                - strike;
    }
}
