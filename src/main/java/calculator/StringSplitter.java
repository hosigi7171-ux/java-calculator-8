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

        // 커스텀 구분자 확인하기
        Character customDelimiter = getCustomDelimiter(inputStr);
        if(customDelimiter != null){
            // "//delimiter\n" 지우기
            inputStr = inputStr.substring(5);
        }

        // 기존 구분자 + 커스텀 구분자로 나누기
        StringBuilder sb = new StringBuilder();
        for(char c : inputStr.toCharArray()){
            // 구분자면 그전까지 내용을 numbers 에 추가
            if(c == ',' || c == ':' || (customDelimiter != null) && c == customDelimiter){
                if(!sb.isEmpty()){
                    numbers.add(Integer.parseInt(sb.toString().trim()));
                    sb.setLength(0);
                }
            }else{ // 아니면 stringBuilder 에 추가
                sb.append(c);
            }
        }
        if(!sb.isEmpty()){ // 마지막 숫자까지
            numbers.add(Integer.parseInt(sb.toString().trim()));
        }

        return numbers;
    }

    /**
     * 커스텀 구분자를 식별하여 리턴하는 메서드
     * @param inputStr 입력받은 문자열
     * @return 커스텀 구분자가 없으면 null 리턴, 있으면 해당 구분자 리턴
     */
    private Character getCustomDelimiter(String inputStr){
        // 커스텀 구분자가 없는 경우
        if(inputStr.length() < 5){
            return null;
        }

        // 커스텀 구분자 유무 체크
        if(inputStr.charAt(0) == '/' && inputStr.charAt(1) == '/'){
            if(inputStr.charAt(3) == '\\' && inputStr.charAt(4) == 'n'){
                return inputStr.charAt(2);
            }
        }

        return null;
    }
}
