package algorithm.solution.dohyoungK.baekjoon.dp;

import algorithm.problem.baekjoon.dp.P10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S10844 implements P10844 {
// TODO: 인접한 모든 자리의 차이가 1인 길이가 N인 계단수 개수 구하기

// TODO: 끝자리가 0 or 9이면 다음 계단수가 1가지만 생성 가능

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10]; // dp[i][j] => 길이가 i이고 끝자리가 j인 계단수 개수
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }


        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] % 1000000000;
            dp[i][9] = dp[i - 1][8] % 1000000000;
            for (int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i] % 1000000000;
        }

        System.out.println(sum);
    }
}
