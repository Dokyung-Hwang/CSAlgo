package algorithm.solution.dohyoungK.baekjoon.dp;

import algorithm.problem.baekjoon.dp.P1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class S1912 implements P1912 {
//  TODO: n개의 수열에서 연속된 수의 최대합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sequences = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[n + 1]; // dp[i] => i번째 수까지의 합
        dp[0] = Integer.MIN_VALUE;
        dp[1] = sequences[0];
        for (int i = 2; i <= n; i++) {
            // max(0, dp[i-1])로 새로 합을 구할지 이전 합을 들고갈지 결정
            dp[i] = Math.max(dp[i - 1], 0) + sequences[i - 1];
        }

        System.out.println(Collections.max(Arrays.stream(dp).boxed().collect(Collectors.toList())));
    }
}
