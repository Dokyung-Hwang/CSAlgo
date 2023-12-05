package algorithm.solution.da9dac.exhaustiveSearch.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.backTracking.P1182;

public class S1182 implements P1182 {
	// https://da9dac.tistory.com/221

	private static int n;
	private static int s;
	private static int count = 0;
	private static int[] arr;
	private static boolean[] isUsed;
	private static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		arr = new int[n];
		isUsed = new boolean[n];
		seq = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		sequence(0, 0, 0);

		System.out.println(count);
	}

	private static void sequence(int size, int start, int sum) {
		if (size == n) {
			if (sum == s) {
				count++;
			}

			return;
		}

		if (size != 0 && sum == s) {
			count++;
		}

		for (int i = start; i < n; i++) {
			if (!isUsed[i]) {
				int num = arr[i];
				seq[size] = num;
				isUsed[i] = true;
				sequence(size + 1, i, sum + num);
				isUsed[i] = false;
			}
		}
	}
}
