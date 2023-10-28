package algorithm.solution.da9dac.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.recursion.P1992;

public class S1992 implements P1992 {
	// https://da9dac.tistory.com/205

	private static int[][] arr;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] videos = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(videos[j]);
			}
		}

		compression(0, 0, n);

		System.out.println(sb);
	}

	private static void compression(int start, int end, int size) {
		if (verification(start, end, size)) {
			if (arr[start][end] == 0) {
				sb.append("0");
			} else {
				sb.append("1");
			}

			return;
		}

		sb.append("(");

		int half = size / 2;

		for (int i = start; i < start + size; i += half) {
			for (int j = end; j < end + size; j += half) {
				compression(i, j, half);
			}
		}

		sb.append(")");
	}

	private static boolean verification(int start, int end, int size) {
		int now = arr[start][end];

		for (int i = start; i < start + size; i++) {
			for (int j = end; j < end + size; j++) {
				if (arr[i][j] != now) {
					return false;
				}
			}
		}

		return true;
	}
}
