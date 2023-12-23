package algorithm.solution.dohyoungK.baekjoon.dp;

import algorithm.problem.baekjoon.dp.P12852;

import java.io.*;

public class S12852 implements P12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] pre = new int[N + 1];
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            pre[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
                pre[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
                pre[i] = i / 3;
            }
        }

        bw.write(dp[N] + "\n");
        bw.write(N + " ");
        while (N != 1) {
            bw.write(pre[N] + " ");
            N = pre[N];
        }

        bw.flush();
        bw.close();
    }
}
