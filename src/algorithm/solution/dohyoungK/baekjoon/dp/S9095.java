package algorithm.solution.dohyoungK.baekjoon.dp;

import algorithm.problem.baekjoon.dp.P9095;

import java.io.*;

public class S9095 implements P9095 {
// TODO:
//  입력받은 n을 1,2,3의 합으로 나타내는 방법의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[12];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int j = 4; j <= n; j++) {
                // dp[j - 1] 의 경우에 +1  ex) dp[4] = dp[3] 경우 끝마다 +1 = 1+1+1 +1, 1+2 +1, 2+1 +1, 3 +1
                // dp[j - 2] 의 경우에 +2
                // dp[j - 3] 의 경우에 +3 만 하면 모든 경우를 찾을 수 있다
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }

            bw.write(dp[n] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
