package algorithm.solution.smileDK.programmers.basic;

import java.util.Arrays;

public class CountUp {
    // https://school.programmers.co.kr/learn/courses/30/lessons/181920
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 10)));
    }

    public static int[] solution(int start_num, int end_num) {
        int[] answer = new int[end_num - start_num + 1];
        int i = 0;

        while (start_num <= end_num) {
            answer[i++] = start_num;
            start_num++;
        }

        return answer;
    }
}
