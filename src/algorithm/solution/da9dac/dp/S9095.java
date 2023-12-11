package algorithm.solution.da9dac.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.dp.P9095;

public class S9095 implements P9095 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] counts = {0, 1, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0};
		for (int i = 4; i <= 11; i++) counts[i] = counts[i - 3] + counts[i - 2] + counts[i - 1];

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) sb.append(counts[Integer.parseInt(br.readLine())]).append("\n");

		System.out.println(sb);
	}
}
