package algorithm.solution.dohyoungK.baekjoon.dp;

import algorithm.problem.baekjoon.dp.P1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1932 implements P1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[501][501];
        for (int i = 0; i < n; i++) {
            triangle[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int maxNum = triangle[0][0];
        int[][] dp = new int[501][501]; // dp[i][j] => i번째 행의 j번째 수를 선택했을 때의 최대 합
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int left = Math.max(0, j - 1);
                int right = Math.min(i - 1, j);
                dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][left], dp[i - 1][right]);

                if (i == n - 1) maxNum = Math.max(maxNum, dp[i][j]);
            }
        }

        System.out.println(maxNum);
    }
}
