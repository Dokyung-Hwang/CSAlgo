package algorithm.solution.da9dac.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.dp.P1003;

public class S1003 implements P1003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] count = new int[n + 1][2];

			for (int i = 0; i <= n; i++) {
				if (i == 0) {
					count[i][0] = 1;
				} else if (i == 1) {
					count[i][1] = 1;
				} else {
					count[i][0] = count[i - 1][0] + count[i - 2][0];
					count[i][1] = count[i - 1][1] + count[i - 2][1];
				}
			}

			sb.append(count[n][0]).append(" ").append(count[n][1]).append("\n");
		}

		System.out.println(sb);
	}
}
