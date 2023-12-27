package algorithm.solution.dohyoungK.baekjoon.twoPointer;

import algorithm.problem.baekjoon.twoPointer.P22862;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S22862 implements P22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] sequences = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = 0;
        int oddCount = 0; // 홀수 개수
        int end = 0;
        for (int start = 0; start < S; start++) {
            while (end < S && oddCount <= N) {
                if (sequences[end++] % 2 == 1) {
                    oddCount++;
                }
            }

            result = Math.max(result, end - start - oddCount);

            if (sequences[start] % 2 == 1) {
                oddCount--;
            }
        }

        System.out.println(result);
    }
}
