package algorithm.solution.smileDK.programmers.basic;

import java.util.Arrays;

public class LastTwoElements {
    // https://school.programmers.co.kr/learn/courses/30/lessons/181927
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 6})));
        System.out.println(Arrays.toString(solution(new int[]{5,2,1,7,5})));
    }

    public static int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];
        int size = num_list.length;
        int first = num_list[size - 1];
        int second = num_list[size - 2];

        System.arraycopy(num_list, 0, answer, 0, size);

        if (first > second)
            answer[answer.length - 1] = first - second;
        else
            answer[answer.length - 1] = first * 2;

        return answer;
    }
}
