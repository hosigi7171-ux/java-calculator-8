package calculator;

public class InputValidator {
    private static final String DEFAULT_DELIMITER_1 = ",";
    private static final String DEFAULT_DELIMITER_2 = ":";

    /**
     * 유효한 입력 문자열인지 확인하는 메서드
     * @param inputStr 입력받은 문자열
     * @throws IllegalArgumentException 올바른 형식이 아니면 exception 발생
     */
    public static void checkValid(String inputStr) throws IllegalArgumentException{
        if(inputStr == null) throw new IllegalArgumentException("inputStr 이 null");
        if(inputStr.isEmpty()) return; // 빈 문자열은 그냥 리턴

        String customDelimiter = null;

        // 커스텀 구분자 있는 경우 올바른 형식인지 체크
        if(inputStr.startsWith(("//"))){
            // 커스텀 구분자 형식이 잘못되었을 경우
            int index = inputStr.indexOf("\\n"); // 이거 \n만 하면 개행문자로 알아먹음
            if(index == -1 || index == 2) throw new IllegalArgumentException("잘못된 커스텀 구분자 형식");

            customDelimiter = java.lang.String.valueOf(inputStr.charAt(2));
            inputStr = inputStr.substring(index+2);
        }

        // 숫자와 구분자가 올바른 형식인지 체크
        String[] tokens = makeDelimiterSame(inputStr, customDelimiter);
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

    /**
     * 구분자들로 문자열을 자르는 메서드
     * @param inputStr 구분할 문자열
     * @param customDelimiter 커스텀 구분자
     * @return 기본 구분자와 커스텀 구분자로 분할한 문자열 배열
     */
    private static String[] makeDelimiterSame(String inputStr, String customDelimiter){
        // custom delimiter 가 있다면
        if(customDelimiter != null){
            inputStr = inputStr.replace(customDelimiter, ",");
        }

        inputStr = inputStr.replace(DEFAULT_DELIMITER_1, ",");
        inputStr = inputStr.replace(DEFAULT_DELIMITER_2, ",");

        return inputStr.split(",");
    }
}
