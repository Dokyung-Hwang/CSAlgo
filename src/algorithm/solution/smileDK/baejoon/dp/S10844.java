package algorithm.solution.smileDK.baejoon.dp;

import algorithm.problem.baekjoon.dp.P10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S10844 implements P10844 {

    private final static long mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n+1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % mod;
                }
                else if (j == 9) {
                    dp[i][9] = dp[i - 1][9] % mod;
                }
                else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }

        long temp = 0;

        for (int i = 0; i < 10; i++) {
            temp += dp[n][i];
        }

        System.out.println(temp % mod);
    }
}
