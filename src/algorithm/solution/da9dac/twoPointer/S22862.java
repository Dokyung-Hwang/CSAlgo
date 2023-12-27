package algorithm.solution.da9dac.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.twoPointer.P22862;

public class S22862 implements P22862 {
	// https://da9dac.tistory.com/266

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int end = 0;
		int max = 0;
		int rm = 0;

		for (int start = 0; start < n; start++) {
			while (end < n) {
				if (arr[end] % 2 != 0) {
					if (rm == k) break;
					rm++;
				}

				end++;
			}

			max = Math.max(max, end - start - rm);

			if (arr[start] % 2 != 0 && rm <= k) rm--;
		}

		System.out.println(max);
	}
}
