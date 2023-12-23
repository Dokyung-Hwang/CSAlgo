package algorithm.solution.dohyoungK.baekjoon.dp;

import algorithm.problem.baekjoon.dp.P2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2579 implements P2579 {
// TODO:
//  정해진 규칙으로 계단을 올라갔을 때
//  얻을 수 있는 점수의 최댓값 출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(stairs[1]);
            return;
        }

        int[][] dp = new int[301][3]; // dp[i][j] => j개의 계단 연속으로 밟고 i번째 계단까지 올라갔을 때 점수
        dp[1][1] = stairs[1];
        dp[1][2] = 0;
        dp[2][1] = stairs[2];
        dp[2][2] = stairs[1] + stairs[2];
        for (int i = 3; i <= n; i++) {
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + stairs[i];
            dp[i][2] = dp[i - 1][1] + stairs[i];
        }

        System.out.println(Math.max(dp[n][1], dp[n][2]));
    }
}
