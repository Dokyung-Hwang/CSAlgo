package algorithm.solution.da9dac.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.twoPointer.P1644;

public class S1644 implements P1644 {
	// https://da9dac.tistory.com/264

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int size = 0;
		int count = 0;

		if (n == 1) {
			System.out.println(count);
			return;
		}

		boolean[] isPrime = new boolean[n + 1];
		int[] arr = new int[n + 1];
		int idx = 0;

		for (int i = 2; i <= n; i++) {
			if (!isPrime[i]) {
				size++;
				arr[idx++] = i;
				for (int j = i * 2; j <= n; j+=i) {
					isPrime[j] = true;
				}
			}
		}

		int end = 1;
		int sum = arr[0];

		for (int start = 0; start < size; start++) {
			while (sum < n && end < size) {
				sum += arr[end++];
			}

			if (sum == n) count++;

			sum -= arr[start];
		}

		System.out.println(count);
	}
}
