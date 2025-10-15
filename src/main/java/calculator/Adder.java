package calculator;

import java.util.List;

public class Adder {
    /**
     * 정수 리스트를 입력받아 합을 구하는 메서드
     * @param numbers 정수 리스트
     * @return 정수들의 합
     */
    public static int sumIntList(List<Integer> numbers){
        int sum = 0;
        for(int num : numbers){
            sum += num;
        }
        return sum;
    }
}
