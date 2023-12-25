package algorithm.solution.da9dac.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import algorithm.problem.baekjoon.greedy.P2217;

public class S2217 implements P2217 {
	// https://da9dac.tistory.com/281

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] weights = new int[n];

		for (int i = 0; i < n; i++) weights[i] = Integer.parseInt(br.readLine());

		Arrays.sort(weights);

		int max = 0;

		for (int i = 0; i < n; i++) max = Math.max(max, weights[i] * (n - i));

		System.out.println(max);
	}
}
