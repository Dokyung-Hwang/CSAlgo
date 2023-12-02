package algorithm.solution.da9dac.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.string.P1969;

public class S1969 implements P1969 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] dna = new char[m][n];

		for (int i = 0; i < n; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				dna[j][i] = chars[j];
			}
		}

		for (int i = 0; i < m; i++) {
			Arrays.sort(dna[i]);
		}

		StringBuilder sb = new StringBuilder();
		int sum = 0;

		for (int i = 0; i < m; i++) {
			int count = 1;
			int max = 1;
			char result = dna[i][0];
			char c = dna[i][0];

			for (int j = 1; j < n; j++) {
				char cur = dna[i][j];

				if (cur != c) {
					c = cur;
					count = 1;
				} else {
					count++;
				}

				if (count > max) {
					max = count;
					result = cur;
				}
			}

			for (char ch : dna[i]) {
				if (ch != result) sum++;
			}

			sb.append(result);
		}

		sb.append("\n").append(sum);
		System.out.println(sb);
	}
}
