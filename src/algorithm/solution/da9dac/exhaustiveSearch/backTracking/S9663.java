package algorithm.solution.da9dac.exhaustiveSearch.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.backTracking.P9663;

public class S9663 implements P9663 {
	// https://da9dac.tistory.com/220

	private static int count = 0;
	private static int n;
	private static boolean[] isUsedY;
	private static boolean[] isUsedLeftCross;
	private static boolean[] isUsedRightCross;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		isUsedY = new boolean[n];
		isUsedLeftCross = new boolean[n * 2 - 1];
		isUsedRightCross = new boolean[n * 2 - 1];

		nQueen(0);

		System.out.println(count);
	}

	private static void nQueen(int x) {
		if (x == n) {
			count++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!isUsedY[i] && !isUsedLeftCross[x + i] && !isUsedRightCross[x - i + n - 1]) {
				isUsedY[i] = true;
				isUsedLeftCross[x + i] = true;
				isUsedRightCross[x - i + n - 1] = true;
				nQueen(x + 1);
				isUsedY[i] = false;
				isUsedLeftCross[x + i] = false;
				isUsedRightCross[x - i + n - 1] = false;

			}
		}
	}
}
