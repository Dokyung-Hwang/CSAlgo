package algorithm.solution.dohyoungK.baekjoon.dp;

import algorithm.problem.baekjoon.dp.P14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S14501 implements P14501 {
//  TODO: N일 동안 퇴사 전까지 상담으로 얻을 수 있는 최대 수익 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 15];  // dp[i] => i일까지 벌 수 있는 최대 수익
        int maxPay = 0;

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int time = Integer.parseInt(input[0]);
            int pay = Integer.parseInt(input[1]);

            dp[i] = Math.max(dp[i], maxPay);
            maxPay = dp[i];
            dp[i + time] = Math.max(dp[i + time], dp[i] + pay); // 지금까지 계산한 값 vs 오늘 새로운 일을 해서 벌 수 있는 소득 비교
        }

        System.out.println(Math.max(dp[N], maxPay));
    }
}
