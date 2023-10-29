package algorithm.solution.da9dac.exhaustiveSearch.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.backTracking.P15654;

public class S15654 implements P15654 {
	// https://da9dac.tistory.com/211

	private static StringBuilder sb = new StringBuilder();
	private static int n;
	private static int m;
	private static int[] arr;
	private static int[] permutation;
	private static boolean[] isUsed;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		arr = new int[n];
		permutation = new int[m];
		isUsed = new boolean[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		createPermutation(0);

		System.out.println(sb);
	}

	private static void createPermutation(int size) {
		if (size == m) {
			for (int i = 0; i < m; i++) {
				sb.append(permutation[i]).append(" ");
			}

			sb.append("\n");

			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!isUsed[i]) {
				permutation[size] = arr[i];
				isUsed[i] = true;
				createPermutation(size + 1);
				isUsed[i] = false;
			}
		}
	}
}
