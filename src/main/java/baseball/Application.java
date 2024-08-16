package baseball;

import baseball.controller.GameController;
import baseball.model.pitcher.ComputerPitcher;
import baseball.model.umpire.UmpireImpl;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(
                new InputView(),
                new OutputView(),
                new ComputerPitcher(),
                new UmpireImpl()
        );
        gameController.run();
    }
}
