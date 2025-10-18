package calculator;

import java.util.List;

public class Calculator {

    /**
     * 검증 + 분리 + 계산 까지 하는 메서드
     */
    public static int calculate(String inputStr){
        // 입력값 검증
        InputValidator.checkValid(inputStr);

        // 숫자 분리
        List<Integer> numbers = StringSplitter.splitToNumbers(inputStr);

        // 합 계산
        return Adder.sumIntList(numbers);
    }
}
