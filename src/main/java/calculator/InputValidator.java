package calculator;

public class InputValidator {
    /**
     * 유효한 입력 문자열인지 확인하는 메서드
     * @param inputStr 입력받은 문자열
     * @throws IllegalArgumentException 올바른 형식이 아니면 exception 발생
     */
    public static void checkValid(String inputStr) throws IllegalArgumentException{
        if(inputStr == null) throw new IllegalArgumentException("inputStr 이 null");
        if(inputStr.isEmpty()) return; // 빈 문자열은 그냥 리턴

        // 커스텀 구분자 있으면 미리 추출
        Character customDelimiter = DelimiterParser.extractCustomDelimiter(inputStr);
        inputStr = DelimiterParser.removeSuffixFormat(inputStr);

        // 숫자와 구분자가 올바른 형식인지 체크
        String[] tokens = DelimiterParser.makeDelimiterSame(inputStr, customDelimiter);
        for(String token : tokens){
            if(token.isEmpty()) throw new IllegalArgumentException("숫자 없이 구분자만 연속 입력한 경우 존재");

            try{
                int num = Integer.parseInt(token);
                if(num < 0 || num > 9) throw new IllegalArgumentException("잘못된 숫자 형식 입력");  
            }catch(NumberFormatException e){
                throw new IllegalArgumentException("잘못된 구분자 또는 숫자 입력");
            }
        }
    }
}
