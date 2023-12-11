package algorithm.solution.da9dac.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.dp.P2579;

public class S2579 implements P2579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] stairs = new int[n + 1];
		int[][] max = new int[n + 1][2];

		for (int i = 1; i <= n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				max[1][0] = stairs[1];
				max[1][1] = stairs[1];
				continue;
			} else if (i == 2) {
				max[2][0] = stairs[2];
				max[2][1] = stairs[1] + stairs[2];
				continue;
			}
			max[i][0] = Math.max(max[i - 2][0], max[i - 2][1]) + stairs[i];
			max[i][1] = max[i - 1][0] + stairs[i];
		}

		System.out.println(Math.max(max[n][0], max[n][1]));
	}
}
