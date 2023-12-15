package algorithm.solution.da9dac.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.twoPointer.P13144;

public class S13144 implements P13144 {
	// https://da9dac.tistory.com/265

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		boolean[] isUsed = new boolean[100001];
		long sum = 0;
		int end = 0;

		for (int start = 0; start < n; start++) {
			while (end < n) {
				if (isUsed[arr[end]]) break;
				isUsed[arr[end++]] = true;
			}

			sum += end - start;
			isUsed[arr[start]] = false;
		}

		System.out.println(sum);
	}
}
