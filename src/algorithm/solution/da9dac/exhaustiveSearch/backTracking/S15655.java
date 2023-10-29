package algorithm.solution.da9dac.exhaustiveSearch.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.backTracking.P15655;

public class S15655 implements P15655 {
	// https://da9dac.tistory.com/212

	private static StringBuilder sb = new StringBuilder();
	private static int n;
	private static int m;
	private static int[] arr;
	private static int[] permutation;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		arr = new int[n];
		permutation = new int[m];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		createSequence(0, 0);

		System.out.println(sb);
	}

	private static void createSequence(int size, int start) {
		if (size == m) {
			for (int i = 0; i < m; i++) {
				sb.append(permutation[i]).append(" ");
			}

			sb.append("\n");

			return;
		}

		for (int i = start; i < arr.length; i++) {
			permutation[size] = arr[i];
			createSequence(size + 1, i + 1);
		}
	}
}
