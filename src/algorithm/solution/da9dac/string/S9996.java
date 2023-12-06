package algorithm.solution.da9dac.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.string.P9996;

public class S9996 implements P9996 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		String[] pattern = br.readLine().split("\\*");
		int sum = pattern[0].length() + pattern[1].length();

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			if (str.length() >= sum &&str.startsWith(pattern[0]) && str.endsWith(pattern[1]))
				sb.append("DA").append("\n");
			else
				sb.append("NE").append("\n");
		}

		System.out.println(sb);
	}
}
