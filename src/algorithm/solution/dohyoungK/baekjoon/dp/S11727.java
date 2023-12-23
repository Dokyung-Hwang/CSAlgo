package algorithm.solution.dohyoungK.baekjoon.dp;

import algorithm.problem.baekjoon.dp.P11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S11727 implements P11727 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001]; // dp[i] => 2 x i 칸을 채울 수 있는 경우의 수
        dp[1] = 1;
        dp[2] = 3;
//        dp[3] = 5;
//        dp[4] = 11;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }

        System.out.println(dp[n]);
    }
}
