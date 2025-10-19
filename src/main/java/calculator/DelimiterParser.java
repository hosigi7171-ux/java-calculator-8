package calculator;

import static calculator.DelimiterConstants.CUSTOM_FORMAT_PREFIX;
import static calculator.DelimiterConstants.CUSTOM_FORMAT_SUFFIX;
import static calculator.DelimiterConstants.DEFAULT_DELIMITER_COLON;
import static calculator.DelimiterConstants.DEFAULT_DELIMITER_COMMA;

public class DelimiterParser {
    private static final int prefixLength = CUSTOM_FORMAT_PREFIX.length();
    private static final int suffixLength = CUSTOM_FORMAT_SUFFIX.length();

    /**
     * 커스텀 구분자를 식별하여 리턴하는 메서드
     * @param inputStr 입력받은 문자열
     * @return 커스텀 구분자가 없으면 null 리턴, 있으면 해당 구분자 리턴
     */
    public static Character extractCustomDelimiter(String inputStr){
        // 커스텀 구분자의 앞부분이 일치하지 않는 경우
        if(!inputStr.startsWith(CUSTOM_FORMAT_PREFIX)){
            return null;
        }

        // 커스텀 구분자가 아예 포맷보다 더 적은 내용을 입력받은 경우
        if(inputStr.length() < prefixLength + 1 + suffixLength){
            return null;
        }

        char customDelimiter = inputStr.charAt(prefixLength);

        // 커스텀 포맷 뒷부분이 일치하지 않는 경우
        String afterDelimiter = inputStr.substring(prefixLength+1, prefixLength+1+suffixLength);
        if(!afterDelimiter.equals(CUSTOM_FORMAT_SUFFIX)){
            return null;
        }

        return customDelimiter;
    }


    /**
     * 입력받은 문자열에서 커스텀 포맷을 제외하고 반환해주는 메서드
     * @param inputStr 입력받은 문자열
     * @return 커스텀 포맷을 제외한 문자열
     */
    public static String removeSuffixFormat(String inputStr){
        Character custom = extractCustomDelimiter(inputStr);

        // 커스텀 문자열 포맷이 없으면 그냥 리턴
        if(custom == null) return inputStr;

        return inputStr.substring(prefixLength + 1 + suffixLength);
    }


    /**
     * 구분자들로 문자열을 자르는 메서드
     * @param inputStr 구분할 문자열
     * @param customDelimiter 커스텀 구분자
     * @return 기본 구분자와 커스텀 구분자로 분할한 문자열 배열
     */
    public static String[] makeDelimiterSame(String inputStr, Character customDelimiter){
        // custom delimiter 가 있다면
        if(customDelimiter != null){
            inputStr = inputStr.replace(customDelimiter, ',');
        }

        inputStr = inputStr.replace(DEFAULT_DELIMITER_COMMA, ",");
        inputStr = inputStr.replace(DEFAULT_DELIMITER_COLON, ",");

        return inputStr.split(",");
    }
}
