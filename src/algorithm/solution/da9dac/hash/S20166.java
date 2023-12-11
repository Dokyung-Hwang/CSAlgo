package algorithm.solution.da9dac.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.hash.P20166;

public class S20166 implements P20166 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		char[][] world = new char[n][m];

		for (int i = 0; i < n; i++) {
			char[] alphabet = br.readLine().toCharArray();

			for (int j = 0; j < m; j++) {
				world[i][j] = alphabet[j];
			}
		}

		for (int i = 0; i < k; i++) {
			String favorite = br.readLine();
		}
	}
}
