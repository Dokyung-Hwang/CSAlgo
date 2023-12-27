package algorithm.solution.da9dac.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.twoPointer.P2531;

public class S2531 implements P2531 {
	// https://da9dac.tistory.com/267

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] belt = new int[n];
		int[] types = new int[d + 1];

		for (int i = 0; i < n; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}

		int end = 0;
		int continues = 0;
		int count = 0;
		int max = 0;

		for (int start = 0; start < n; start++) {
			while (continues < k) {
				if (types[belt[end]] == 0) count++;
				types[belt[end++]]++;
				if (end == n) end = 0;
				continues++;
			}

			if (types[c] == 0) {
				max = Math.max(count + 1, max);
			} else {
				max = Math.max(count, max);
			}

			types[belt[start]]--;
			if (types[belt[start]] == 0) count--;

			continues--;
		}

		System.out.println(max);
	}
}
