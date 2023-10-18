package algorithm.solution.dohyoungK.programmers.sort;

import algorithm.problem.programmers.sort.P3;

import java.util.Arrays;
import java.util.Collections;

public class S3 implements P3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0,0,0,0}));
    }

    public static int solution(int[] citations) {
        Integer[] citations2 = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(citations2 ,Collections.reverseOrder());

        if (citations2[0].equals(0)) return 0;

        for (int i = 0; i < citations2.length - 1; i++) {
            if (citations2[i].equals(i + 1)) return citations2[i];
            else if (citations2[i] < i + 1) {
                for (int j = citations2[i - 1] - 1; j >= 0; j--) {
                    if (j == i) return j;
                }
            }
        }

        for (int j = citations2[citations2.length - 1] - 1; j >= 0; j--) {
            if (j == citations2.length) return j;
        }

        return 0;
    }
}
