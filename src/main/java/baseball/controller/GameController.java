package baseball.controller;

import baseball.controller.dto.BaseballNumberDto;
import baseball.controller.restarter.RestartState;
import baseball.model.pitcher.Pitcher;
import baseball.model.umpire.Umpire;
import baseball.model.vo.BaseballNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final InputView in;
    private final OutputView out;
    private final Pitcher pitcher;
    private final Umpire umpire;

    public GameController(InputView in, OutputView out, Pitcher pitcher, Umpire umpire) {
        this.in = in;
        this.out = out;
        this.pitcher = pitcher;
        this.umpire = umpire;
    }

    public void run() {
        out.displayStartMessage();
        while (true) {
            startGame();
            RestartState state = RestartState.findState(in.inputRestartNumber());
            if (state.isEndGame()) {
                break;
            }
        }
    }

    private void startGame() {
        // 게임 끝날 때 까지 상태 지속
        BaseballNumber pitcherNumber = pitcher.generate();
        // 무상태
        while (true) {
            BaseballNumberDto baseballNumberDto = in.inputBaseballNumber();
            BaseballNumber hitterNumber = BaseballNumber.of(baseballNumberDto.numbers());

            int strike = umpire.determineStrike(pitcherNumber, hitterNumber);
            int ball = umpire.determineBall(pitcherNumber, hitterNumber, strike);

            out.displayResult(strike, ball);

            if (strike == 3) {
                break;
            }
        }
        out.displayEndMessage();
    }
}
