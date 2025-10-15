package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringSplitter {
    /**
     * input 문자열을 구분자로 분리하는 메서드
     * @param inputStr 분리할 문자열
     * @return 구분자로 나눈 숫자 리스트
     */
    public List<Integer> splitToNumbers(String inputStr){
        List<Integer> numbers = new ArrayList<>();
        
        if(inputStr == null || inputStr.isEmpty()){
            return numbers;
        }

        // 기본 구분자로 나누기
        String[] tokens = inputStr.split("[,|:]");

        // 나눠진 문자열을 numbers 정수 리스트에 추가
        for(String token : tokens){
            if(!token.isEmpty()){
                numbers.add(Integer.parseInt(token));
            }
        }

        return numbers;
    }
}
