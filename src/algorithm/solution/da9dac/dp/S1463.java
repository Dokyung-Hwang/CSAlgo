package algorithm.solution.da9dac.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.dp.P1463;

public class S1463 implements P1463 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] counts = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			counts[i] = counts[i - 1] + 1;
			if (i % 2 == 0) counts[i] = Math.min(counts[i], counts[i/2] + 1);
			if (i % 3 == 0) counts[i] = Math.min(counts[i], counts[i/3] + 1);
		}

		System.out.println(counts[n]);
	}
}
