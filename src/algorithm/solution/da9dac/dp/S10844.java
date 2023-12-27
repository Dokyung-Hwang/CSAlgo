package algorithm.solution.da9dac.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.dp.P10844;

public class S10844 implements P10844 {
	// https://da9dac.tistory.com/279

	private static final int MOD = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		byte n = Byte.parseByte(br.readLine());

		long[][] dp = new long[n + 1][10];

		dp[1] = new long[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1};

		for (byte i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][1] % MOD;
			dp[i][9] = dp[i - 1][8] % MOD;
			for (byte j = 1; j < 9; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
			}
		}

		long count = 0;

		for (byte i = 0; i < 10; i++) {
			count += dp[n][i];
		}

		System.out.println(count % MOD);
	}
}
