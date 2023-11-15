package algorithm.solution.da9dac.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.sort.P5648;

public class S5648 implements P5648 {
	// https://da9dac.tistory.com/251

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		long[] arr = new long[n];
		int idx = 0;

		while (true) {
			if (st.hasMoreTokens()) {
				StringBuilder input = new StringBuilder(st.nextToken());
				arr[idx++] = Long.parseLong(input.reverse().toString());
				if (idx == n) break;
			} else {
				st = new StringTokenizer(br.readLine());
			}
		}

		Arrays.sort(arr);

		for (long a : arr) {
			sb.append(a).append("\n");
		}

		System.out.println(sb);
	}
}
