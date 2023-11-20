package algorithm.solution.da9dac.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.sort.P2750;

public class S2750 implements P2750 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		boolean[] arr = new boolean[2001];

		for (int i = 0; i < n; i++) {
			arr[Integer.parseInt(br.readLine()) + 1000] = true;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i]) sb.append(i - 1000).append("\n");
		}

		System.out.println(sb);
	}
}
