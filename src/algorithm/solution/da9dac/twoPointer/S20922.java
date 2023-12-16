package algorithm.solution.da9dac.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.twoPointer.P20922;

public class S20922 implements P20922 {
	// https://da9dac.tistory.com/268

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		int[] useCount = new int[200_001];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int end = 0;
		int max = 0;

		for (int start = 0; start < n; start++) {
			while (end < n) {
				if (useCount[arr[end]] == k) break;
				useCount[arr[end++]]++;
			}

			max = Math.max(max, end - start);

			useCount[arr[start]]--;
		}

		System.out.println(max);
	}
}
