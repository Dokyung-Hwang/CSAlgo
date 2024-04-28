package algorithm.solution.smileDK.programmers.etc;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/120813
public class HateEvenNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10)));
        System.out.println(Arrays.toString(solution(15)));
    }

    public static int[] solution(int n) {
        int[] answer = {};
        int index = 0;

        if (n % 2 == 0) answer = new int[n / 2];
        else answer = new int[n / 2 + 1];

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 1) {
                answer[index] = i;
                index++;
            }
        }

        return answer;
    }
}
