package algorithm.solution.da9dac.exhaustiveSearch.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.backTracking.P15666;

public class S15666 implements P15666 {
	// https://da9dac.tistory.com/218

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

		arr = new int[n];
		sequence = new int[m];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		createSequence(0, 0);

		System.out.println(sb);
	}

	private static void createSequence(int size, int start) {
		if (size == m) {
			for (int seq : sequence) {
				sb.append(seq).append(" ");
			}
			sb.append("\n");
			return;
		}

		int before = 0;

		for (int i = start; i < n; i++) {
			if (before != arr[i]) {
				sequence[size] = arr[i];
				before = arr[i];
				createSequence(size + 1, i);
			}
		}
	}
}
