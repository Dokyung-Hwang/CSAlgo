package algorithm.solution.dohyoungK.baekjoon.dp;

import algorithm.problem.baekjoon.dp.P11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class S11055 implements P11055 {
//  TODO: 수열 A에서 증가하는 부분 수열 중 최대 합 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sequences = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[N];
        dp[0] = sequences[0];
        for (int i = 1; i < N; i++) {
            dp[i] = sequences[i];
            for (int j = 0; j < i; j++) {
                // 증가 수열인지
                if (sequences[i] > sequences[j]) {
                    // 더해서 최대합이 되는지
                    dp[i] = Math.max(dp[i], dp[j] + sequences[i]);
                }
            }
        }

        System.out.println(Collections.max(Arrays.stream(dp).boxed().collect(Collectors.toList())));
    }
}
