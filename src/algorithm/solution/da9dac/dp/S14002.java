package algorithm.solution.da9dac.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.dp.P14002;

public class S14002 implements P14002 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n];
		dp[0] = 1;

		int max = 1;

		for (int i = 1; i < n; i++) {
			dp[i] = 1;

			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}

			max = Math.max(max, dp[i]);
		}

		sb.append(max).append("\n");

		Stack<Integer> stack = new Stack<>();

		for (int i = n - 1; i >= 0; i--) {
			if (dp[i] == max) {
				stack.push(arr[i]);
				max--;
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}

		System.out.println(sb);
	}
}
