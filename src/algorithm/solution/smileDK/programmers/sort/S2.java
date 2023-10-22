package algorithm.solution.smileDK.programmers.sort;

import algorithm.problem.programmers.sort.P2;

import java.util.Arrays;

public class S2 implements P2 {
    public static void main(String[] args) {
        int[] numbers1 = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};

        System.out.println(solution(numbers1));
        System.out.println(solution(numbers2));
    }

    public static String solution(int[] numbers) {
        // 정수 -> 문자열

        String[] result = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
//            result[i] = String.valueOf(numbers[i]);
            result[i] = Integer.toString(numbers[i]);
        }

        // 정렬
//        Arrays.sort(result, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return ((o2+o1).compareTo(o1+o2));
//            }
//        });
        Arrays.sort(result, (o1, o2) -> ((o2+o1).compareTo(o1+o2)));


        // 0만 있는 배열 -> 0 반환
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