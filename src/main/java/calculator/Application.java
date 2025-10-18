package calculator;

public class Application {
    public static void main(String[] args) {
        // 문자열 입력받기 : 입력
        String inputStr = InputReader.read();
        
        // 문자열 계산값 구하기 : 검증 + 분리 + 계산 과정 포함
        int sumResult = Calculator.calculate(inputStr);

        // 결과 출력
        ResultPrinter.print(sumResult);
    }
}
