package algorithm.solution.da9dac.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.dp.P14501;

public class S14501 implements P14501 {
	// https://da9dac.tistory.com/277

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] times = new int[n + 1];
		int[] prices = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			times[i] = Integer.parseInt(st.nextToken());
			prices[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n + 1];
		int result = 0;

		for (int i = 1; i <= n; i++) {
			if (i + times[i] - 1 > n) continue;

			int max = prices[i];

			for (int j = 1; j < i; j++) {
				if (j + times[j] - 1 < i) max = Math.max(prices[i] + dp[j], max);
			}

			dp[i] = max;
			result = Math.max(max, result);
		}

		System.out.println(result);
	}
}
