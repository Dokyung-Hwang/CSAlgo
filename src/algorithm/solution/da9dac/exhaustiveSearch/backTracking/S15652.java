package algorithm.solution.da9dac.exhaustiveSearch.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.backTracking.P15652;

public class S15652 implements P15652 {
	// https://da9dac.tistory.com/210

	private static StringBuilder sb = new StringBuilder();
	private static int n;
	private static int m;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");

		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);

		arr = new int[m];

		makeNumber(0, 1);

		System.out.println(sb);
	}

	private static void makeNumber(int size, int start) {
		if (size == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}

			sb.append("\n");

			return;
		}

		for (int i = start; i <= n; i++) {
			arr[size] = i;
			makeNumber(size + 1, i);
		}
	}
}
