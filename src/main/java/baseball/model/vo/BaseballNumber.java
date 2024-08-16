package baseball.model.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class BaseballNumber {

    private final List<Integer> number;

    // constructor
    private BaseballNumber(List<Integer> input) {
        validateNotIncludeZero(input);
        validateNot3Digit(input);
        validateDuplicate(input);
        this.number = input;
    }

    // static factory method
    public static BaseballNumber of(List<Integer> input) {
        return new BaseballNumber(input);
    }

    // validation
    private void validateNotIncludeZero(List<Integer> input) {
        if (isIncludeZero(input)) {
            throw new IllegalArgumentException("0을 포함할 수 없습니다.");
        }
    }

    private boolean isIncludeZero(List<Integer> input) {
        return input.stream()
                .anyMatch(n -> n == 0);
    }

    private void validateNot3Digit(List<Integer> input) {
        if (input.size() != 3) {
            throw new IllegalArgumentException("3자리가 아닙니다.");
        }
    }

    private void validateDuplicate(List<Integer> input) {
        if (isDuplicateEachNumber(input)){
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private boolean isDuplicateEachNumber(List<Integer> input) {
        return new HashSet<>(input)
                .size() != 3;
    }

    // getter
    public List<Integer> getNumber() {
        return List.copyOf(number);
    }

    // immutable object
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseballNumber that = (BaseballNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
