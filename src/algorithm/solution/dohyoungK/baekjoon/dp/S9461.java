package algorithm.solution.dohyoungK.baekjoon.dp;

import algorithm.problem.baekjoon.dp.P9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S9461 implements P9461 {
//  TODO: 나선모양으로 삼각형을 N개 만들었을 때의 최장 변의 길이
// 1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12, 16, 21,

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int maxNum = 6;
            long[] dp = new long[101];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;
            dp[5] = 2;

            for (int i = maxNum; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 5];
            }

            maxNum = Math.max(maxNum, N);
            System.out.println(dp[N]);
        }
    }
}
