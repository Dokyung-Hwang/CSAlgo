package algorithm.solution.DokyungHwang.programmers.sort;

import algorithm.problem.programmers.sort.P3;

import java.util.Arrays;

public class S3 implements P3 {

    public static void main(String[] args) {
        int[] testcase = {3,0,6,1,5};

        System.out.println(solution(testcase));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for(int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
