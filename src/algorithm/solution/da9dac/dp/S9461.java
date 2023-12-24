package algorithm.solution.da9dac.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.dp.P9461;

public class S9461 implements P9461 {
	// https://da9dac.tistory.com/276

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		int max = 0;

		int[] tc = new int[t];
		long[] dp = new long[101];

		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			tc[i] = n;
			max = Math.max(max, n);
		}

		for (int i = 6; i <= max; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}

		for (int n : tc) {
			sb.append(dp[n]).append("\n");
		}

		System.out.println(sb);
	}
}
