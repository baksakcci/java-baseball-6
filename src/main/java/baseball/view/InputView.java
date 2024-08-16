package baseball.view;

import baseball.controller.dto.BaseballNumberDto;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String inputMessage = "숫자를 입력해주세요 : ";
    private static final String restartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public BaseballNumberDto inputBaseballNumber() {
        System.out.print(inputMessage);
        String input = Console.readLine();
        return from(input);
    }

    private BaseballNumberDto from(String input) {
        validateIsNumeric(input);
        List<Integer> integers = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
        return new BaseballNumberDto(integers);
    }

    private void validateIsNumeric(String input) {
        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public String inputRestartNumber() {
        System.out.println(restartMessage);
        return Console.readLine();
    }
}