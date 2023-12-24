package algorithm.solution.dohyoungK.baekjoon.dp;

import algorithm.problem.baekjoon.dp.P11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S11726 implements P11726 {
// TODO:
//  2 x n 직사각형을 1 × 2, 2 × 1 타일로 채우는 방법의 수 찾기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001]; // dp[i] 2 x i 개 타일을 채울 수 있는 경우의 수
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
