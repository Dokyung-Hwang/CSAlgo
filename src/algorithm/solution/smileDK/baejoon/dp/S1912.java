package algorithm.solution.smileDK.baejoon.dp;

import algorithm.problem.baekjoon.dp.P1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1912 implements P1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] sequence = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = sequence[0];
        int max = sequence[0];

        for (int i = 1; i < n; i++) {
            // (이전 dp + 현재 arr값) 과 현재 arr값 중 큰 것을 dp에 저장
            dp[i] = Math.max(dp[i - 1] + sequence[i], sequence[i]);
            // 최댓값 갱신
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
