package calculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        StringSplitter splitter = new StringSplitter();
        
        String inputStr; // 입력받는 문자열
        
        // 문자열 입력받기
        inputStr = inputReader.getInput();

        // 숫자 배열로 나누기
        List<Integer> numbers = splitter.splitToNumbers(inputStr);



        System.out.println(numbers);
    }
}
