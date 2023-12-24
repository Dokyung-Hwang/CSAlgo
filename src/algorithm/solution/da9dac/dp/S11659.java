package algorithm.solution.da9dac.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.dp.P11659;

public class S11659 implements P11659 {
	// https://da9dac.tistory.com/272

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] dp = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		dp[1] = Integer.parseInt(st.nextToken());

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());

			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			sb.append(dp[j] - dp[i - 1]).append("\n");
		}

		System.out.println(sb);
	}
}
