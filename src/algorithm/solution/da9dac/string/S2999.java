package algorithm.solution.da9dac.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.string.P2999;

public class S2999 implements P2999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] secrets = br.readLine().toCharArray();

		int length = secrets.length;
		int r = 0;
		int c = 0;

		for (int i = (int) Math.sqrt(length); i >= 1; i++) {
			if (length % i == 0) {
				int x = length / i;
				int y = length / x;

				r = Math.min(x, y);
				c = Math.max(x, y);
				break;
			}
		}

		char[][] chars = new char[r][c];
		int idx = 0;

		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				chars[j][i] = secrets[idx++];
			}
		}

		StringBuilder sb = new StringBuilder();

		for (char[] ch : chars) {
			sb.append(ch);
		}

		System.out.println(sb);
	}
}
