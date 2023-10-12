package algorithm.solution.DokyungHwang.programmers.sort;

import algorithm.problem.programmers.sort.P2;

import java.util.Arrays;
import java.util.Comparator;

public class S2 implements P2 {
    public static void main(String[] args) {

    }

    public static String solution(int[] numbers) {
        // 정수 -> 문자열

        String[] result = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }

        // 정렬
        Arrays.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((o2+o1).compareTo(o1+o2));
            }
        });


        // 0 중복복
        if (result[0].equals("0")) {
            return "0";
        }

        // 출력
        String answer = "";

        for (String s : result) {
            answer+=s;
        }

        return answer;
    }
}