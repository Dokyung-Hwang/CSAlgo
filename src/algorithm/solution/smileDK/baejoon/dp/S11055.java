package algorithm.solution.smileDK.baejoon.dp;

import algorithm.problem.baekjoon.dp.P11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S11055 implements P11055 {

    private static int[] dp;
    private static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        cost = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = cost[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = cost[i];
            for (int j = 1; j < i; j++) {
                if (cost[i] > cost[j]) {
                    dp[i] = Math.max(cost[i] + dp[j], dp[i]);
                }
            }
        }

        int max = 0;

        for (int i = 0; i < dp.length; i++) {
            if (max < dp[i])
                max = dp[i];
        }

        System.out.println(max);
    }
}
