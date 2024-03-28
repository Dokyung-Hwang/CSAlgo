package algorithm.solution.smileDK.baejoon.dp;

import algorithm.problem.baekjoon.dp.P1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1003 implements P1003 {

    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        dp = new int[41][2];

        dp[0][0] = 1;
        dp[1][1] = 1;

        for (int i = 2; i < 41; i++) {
            for(int j = 0; j < 2; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 2][j];
            }
        }


        StringBuilder sb = new StringBuilder();

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }

        System.out.println(sb);
    }
}
