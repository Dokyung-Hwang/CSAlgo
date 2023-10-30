package algorithm.solution.da9dac.exhaustiveSearch.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.backTracking.P15663;

public class S15663 implements P15663 {
	// https://da9dac.tistory.com/215

	private static StringBuilder sb = new StringBuilder();
	private static int n;
	private static int m;
	private static int[] arr;
	private static int[] sequence;
	private static boolean[] isUsed;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		sequence = new int[m];
		isUsed = new boolean[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		createSequence(0);

		System.out.println(sb);
	}

	private static void createSequence(int size) {
		if (size == m) {
			for (int seq : sequence) {
				sb.append(seq).append(" ");
			}
			sb.append("\n");

			return;
		}

		int before = 0;

		for (int i = 0; i < n; i++) {
			if (!isUsed[i] && before != arr[i]) {
				sequence[size] = arr[i];
				isUsed[i] = true;
				before = arr[i];
				createSequence(size + 1);
				isUsed[i] = false;
			}
		}
	}
}
