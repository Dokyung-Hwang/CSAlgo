package algorithm.solution.dohyoungK.baekjoon.dp;

import algorithm.problem.baekjoon.dp.P1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1149 implements P1149 {
// TODO:
//  빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때
//  모든 집을 칠하는 최소 비용 출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] expense = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            expense[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] dp = new int[N + 1][3];
        dp[1] = expense[1];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + expense[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + expense[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + expense[i][2];
        }

        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
    }
}
