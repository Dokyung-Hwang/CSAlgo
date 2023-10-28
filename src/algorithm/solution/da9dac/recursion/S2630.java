package algorithm.solution.da9dac.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.recursion.P2630;

public class S2630 implements P2630 {
	// https://da9dac.tistory.com/204


	private static int[][] arr;
	private static int[] count = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");

			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}

		count(0, 0, n);

		sb.append(count[0]).append("\n");
		sb.append(count[1]).append("\n");

		System.out.println(sb);
	}

	private static void count(int start, int end, int size) {
		if (verification(start, end, size)) {
			if (arr[start][end] == 0) {
				count[0]++;
			} else {
				count[1]++;
			}

			return;
		}

		int newSize = size / 2;

		for (int i = start; i < size + start; i += newSize) {
			for (int j = end; j < size + end; j += newSize) {
				count(i, j, newSize);
			}
		}
	}

	private static boolean verification(int start, int end, int size) { // 0 4 4
		int now = arr[start][end];

		for (int i = start; i < start + size; i++) {
			for (int j = end; j < end + size; j++) {
				if (now != arr[i][j]) return false;
			}
		}

		return true;
	}
}
