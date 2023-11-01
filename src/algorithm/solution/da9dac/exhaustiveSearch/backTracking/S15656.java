package algorithm.solution.da9dac.exhaustiveSearch.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.backTracking.P15656;

public class S15656 implements P15656 {
	// https://da9dac.tistory.com/213

	private static StringBuilder sb = new StringBuilder();
	private static int n;
	private static int m;
	private static int[] arr;
	private static int[] sequence;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		arr = new int[n];
		sequence = new int[m];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		createSequence(0);

		System.out.println(sb);
	}

	private static void createSequence(int size) {
		if (size == m) {
			for (int i = 0; i < m; i++) {
				sb.append(sequence[i]).append(" ");
			}

			sb.append("\n");

			return;
		}

		for (int i = 0; i < arr.length; i++) {
			sequence[size] = arr[i];
			createSequence(size + 1);
		}
	}
}
