package algorithm.solution.da9dac.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.greedy.P11399;

public class S11399 implements P11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] line = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(line);

		int min = 0;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += line[i];
			min += sum;
		}

		System.out.println(min);
	}
}
