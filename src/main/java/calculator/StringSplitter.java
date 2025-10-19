    package calculator;

    import java.util.ArrayList;
    import java.util.List;

    public class StringSplitter {
        /**
         * input 문자열을 구분자로 분리하는 메서드
         * @param inputStr 분리할 문자열
         * @return 구분자로 나눈 숫자 리스트
         */
        public static List<Integer> splitToNumbers(String inputStr){
            List<Integer> numbers = new ArrayList<>();

            if(inputStr == null || inputStr.isEmpty()){
                return numbers;
            }

            // 커스텀 구분자 있으면 미리 추출
            Character customDelimiter = DelimiterParser.extractCustomDelimiter(inputStr);
            inputStr = DelimiterParser.removeSuffixFormat(inputStr);

            // 숫자와 구분자가 올바른 형식인지 체크
            String[] tokens = DelimiterParser.makeDelimiterSame(inputStr, customDelimiter);
            for(String token : tokens){
                if(!token.isEmpty()){
                    numbers.add(Integer.parseInt(token.trim()));
                }
            }

            return numbers;
        }
    }
