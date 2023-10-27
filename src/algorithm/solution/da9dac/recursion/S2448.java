package algorithm.solution.da9dac.recursion;

import java.io.*;
import java.util.Arrays;

import algorithm.problem.baekjoon.recursion.P2448;

public class S2448 implements P2448 {
	// https://da9dac.tistory.com/207

	private static char[][] stars;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		stars = new char[n][2*n-1];

		for (int i = 0; i < n; i++) {
			Arrays.fill(stars[i], ' ');
		}

		createStar(n, 0, n - 1);

		for (char[] star : stars) {
			bw.write(star);
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}

	private static void createStar(int size, int x, int y) {
		if (size == 3) {
			stars[x][y] = '*';

			stars[x + 1][y - 1] = '*';
			stars[x + 1][y + 1] = '*';

			for (int i = y - 2; i <= y + 2; i++) {
				stars[x + 2][i] = '*';
			}

			return;
		}

		int newSize = size / 2;

		createStar(newSize, x, y);
		createStar(newSize, x + newSize, y - newSize);
		createStar(newSize, x + newSize, y + newSize);
	}
}
