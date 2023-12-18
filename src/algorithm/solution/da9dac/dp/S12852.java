package algorithm.solution.da9dac.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.dp.P12852;

public class S12852 implements P12852 {
	// https://da9dac.tistory.com/273

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];
		int[] history = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			history[i] = i - 1;

			if (i % 2 == 0 && dp[i] > dp[i/2] + 1) {
				dp[i] = dp[i/2] + 1;
				history[i] = i/2;
			}

			if (i % 3 == 0 && dp[i] > dp[i/3] + 1) {
				dp[i] = dp[i/3] + 1;
				history[i] = i/3;
			}
		}

		StringBuilder sb = new StringBuilder();

		sb.append(dp[n]).append("\n");

		int num = n;

		while (true) {
			sb.append(num).append(" ");
			if (num == 1) break;
			num = history[num];
		}

		System.out.println(sb);
	}
}
