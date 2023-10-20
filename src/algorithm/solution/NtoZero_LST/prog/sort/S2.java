package algorithm.solution.NtoZero_LST.prog.sort;

import algorithm.problem.programmers.sort.P2;

import java.util.Arrays;

public class S2 implements P2 {
    /*
        원소 : 10^3, number의 길이 : 10^5
        숫자가 아닌 문자열 요소를 이어 붙인 값을 비교해가며 내림차순을 해야 자리 수별 비교가 가능하다.
        1. 문자열 요소로 변경한다.
        2. Comparator 람다식을 사용한다.
        3. 예외 조건 요소가 모두 0일 때 0을 반환한다.
    */

    public String solution(int[] numbers) {
        // 1. 문자열 요소로 변환
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 2. 두 문자를 이어 붙였을 때 비교하여 내림차순
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 3. 모든 요소가 0인 경우 예외 조건 추가
        if (arr[0].equals("0")) {
            return "0";
        }

        // 4. 배열의 모든 요소를 순회하며 이어 붙여줄 StringBuilder
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }


        return answer.toString();
    }
}
