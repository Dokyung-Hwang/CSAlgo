package algorithm.solution.da9dac.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.dp.P1912;

public class S1912 implements P1912 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[] dp = new long[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		dp[0] = Long.parseLong(st.nextToken());
		long max = dp[0];

		for (int i = 1; i < n; i++) {
			long l = Long.parseLong(st.nextToken());
			dp[i] = Math.max(dp[i - 1] + l, l);
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);
	}
}
