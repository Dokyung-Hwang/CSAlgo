package algorithm.solution.dohyoungK.baekjoon.dp;

import algorithm.problem.baekjoon.dp.P2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2193 implements P2193 {
//  TODO: N자리 이친수 개수 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[91][2]; // dp[i][j] => i자리의 이친수 중 0으로 끝나는 개수, 1으로 끝나는 개수
        dp[1][0] = 0;
        dp[1][1] = 1; // 1
        dp[2][0] = 1; // 10
        dp[2][1] = 0;
//        dp[3] = 2; // 100, 101   1,1
//        dp[4] = 3; // 1000, 1010, 1001    2,1
//        dp[5] = 5; // 10000, 10100, 10010, 10001, 10101   3,2
//        dp[6] = 8; // 100000, 101000, 100100, 100010, 101010, 100001, 101001, 100101   5,3

        for (int i = 3; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1]; // 뒤에 0 붙일 수 있는 수
            dp[i][1] = dp[i - 1][0]; // 뒤에 1 붙일 수 있는 수
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}
