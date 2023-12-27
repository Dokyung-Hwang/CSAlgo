package algorithm.solution.da9dac.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.dp.P15486;

public class S15486 implements P15486 {
	// https://da9dac.tistory.com/278

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 51];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			int time = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());

			dp[i] = Math.max(dp[i], dp[i - 1]);
			dp[i + time] = Math.max(dp[i + time], dp[i] + price);
		}

		System.out.println(Math.max(dp[n], dp[n + 1]));
	}
}
