package algorithm.solution.dohyoungK.baekjoon.dp;

import algorithm.problem.baekjoon.dp.P1003;

import java.io.*;

public class S1003 implements P1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int start = 2;

        int[][] dp = new int[41][2]; // dp[i][j] 피보나치(i)에 j(0 or 1)이 몇번 나오는지
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            for (int j = start; j <= N; j++) {
                dp[j][0] = dp[j - 1][0] + dp[j - 2][0];
                dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
            }

            start = Math.max(2, N);
            bw.write(dp[N][0] + " " + dp[N][1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
