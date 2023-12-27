package algorithm.solution.da9dac.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.dp.P1149;

public class S1149 implements P1149 {
	// https://da9dac.tistory.com/269

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] rgb = new int[n][3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[n][3];

		dp[0][0] = rgb[0][0];
		dp[0][1] = rgb[0][1];
		dp[0][2] = rgb[0][2];

		for (int i = 1; i < n; i++) {
			int r = rgb[i][0];
			int g = rgb[i][1];
			int b = rgb[i][2];

			int pr = dp[i - 1][0];
			int pg = dp[i - 1][1];
			int pb = dp[i - 1][2];

			dp[i][0] = Math.min(pg, pb) + r;
			dp[i][1] = Math.min(pr, pb) + g;
			dp[i][2] = Math.min(pr, pg) + b;
		}

		System.out.println(Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2])));
	}
}
