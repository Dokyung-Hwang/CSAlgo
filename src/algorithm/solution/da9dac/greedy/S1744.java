package algorithm.solution.da9dac.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import algorithm.problem.baekjoon.greedy.P1744;

public class S1744 implements P1744 {
	// https://da9dac.tistory.com/287

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int count = 0;
		int[] seq = new int[n];

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			seq[i] = x;
			if (x <= 0) count++;
		}

		Arrays.sort(seq);

		long prev = -1001;
		long sum = 0;

		for (int i = 0; i < count; i++) {
			int cur = seq[i];

			if (i == count - 1 && count % 2 != 0) {
				sum += cur;
				continue;
			}

			if (prev < -1000) {
				prev = cur;
				continue;
			}

			sum += (prev * cur);
			prev = -1001;
		}

		prev = -1001;

		for (int i = count; i < n; i++) {
			int cur = seq[i];

			if (i == count && (n - count) % 2 != 0) {
				sum += cur;
				continue;
			}

			if (prev < -1000) {
				prev = cur;
				continue;
			}

			if (prev * cur == cur) sum += (prev + cur);
			else sum += (prev * cur);
			prev = -1001;
		}

		System.out.println(sum);
	}
}
