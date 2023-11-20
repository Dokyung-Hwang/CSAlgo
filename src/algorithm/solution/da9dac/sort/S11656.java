package algorithm.solution.da9dac.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import algorithm.problem.baekjoon.sort.P11656;

public class S11656 implements P11656 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();
		int legnth = input.length();
		String[] arr = new String[legnth];

		for (int i = 0; i < legnth; i++) {
			arr[i] = input.substring(i, legnth);
		}

		Arrays.sort(arr);

		for (String s : arr) {
			sb.append(s).append("\n");
		}

		System.out.println(sb);
	}
}
