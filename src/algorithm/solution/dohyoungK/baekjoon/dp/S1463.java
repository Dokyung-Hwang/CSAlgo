package algorithm.solution.dohyoungK.baekjoon.dp;

import algorithm.problem.baekjoon.dp.P1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1463 implements P1463 {
// TODO:
//  3가지 연산을 사용해 입력받은 N을 1로 만드는 최소 연산 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 3번 연산
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 3번 연산과 2번 연산 중 최솟값 구하기
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 3번 연산과 1번 연산 중 최솟값 구하기
        }

        System.out.println(dp[N]);
    }
}
