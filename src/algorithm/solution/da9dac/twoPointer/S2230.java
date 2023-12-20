package algorithm.solution.da9dac.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.twoPointer.P2230;

public class S2230 implements P2230 {
	// https://da9dac.tistory.com/262

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int s = 0;
		int e = 1;
		int min = Integer.MAX_VALUE;

		while (e < n) {
			int minus = arr[e] - arr[s];
			if (minus == m) {
				min = m;
				break;
			}

			if (minus >= min) {
				s++;
				continue;
			}

			if (minus > m) {
				min = minus;
				s++;
			}
			else e++;
		}

		System.out.println(min);
	}
}
