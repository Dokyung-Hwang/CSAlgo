package algorithm.solution.da9dac.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.dp.P2240;

public class S2240 implements P2240 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int[] plums = new int[t];

		for (int i = 0; i < t; i++) {
			plums[i] = Integer.parseInt(br.readLine());
		}

		int[][] dp = new int[t][w + 1];
		int max = 1;

		if (plums[0] == 1) {
			dp[0][0] = 1;
		}
		else {
			dp[0][1] = 1;
		}

		for (int i = 1; i < t; i++) {
			int plum = plums[i];

			if (plum == 1) {
				dp[i][0] = dp[i - 1][0] + 1;
			} else {
				dp[i][0] = dp[i - 1][0];
			}
			max = Math.max(max, dp[i][0]);

			for (int j = 1; j <= w; j++) {
				if (j % 2 == 0) {
					if (plum == 1) {
						dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1]);
					} else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + 1);
					}
				} else {
					if (plum == 2) {
						dp[i][j] = Math.max(dp[i-1][j] + 1, dp[i-1][j-1]);
					} else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] + 1);
					}
				}
				max = Math.max(max, dp[i][j]);
			}

		}

		System.out.println(max);
	}
}
