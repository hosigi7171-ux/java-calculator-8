package calculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String inputStr; // 입력받는 문자열
        
        // 문자열 입력받기
        inputStr = InputReader.read();
        
        // 입력받은 문자열 유효한지 체크 아니면 throw exception
        InputValidator.checkValid(inputStr);
        
        // 숫자 배열로 나누기
        List<Integer> numbers = StringSplitter.splitToNumbers(inputStr);

        // 숫자 배열로 합을 구하기
        int sum = 0;
        sum = Adder.sumIntList(numbers);

        // 결과 출력
        ResultPrinter.print(sum);
    }
}
