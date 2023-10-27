package algorithm.solution.da9dac.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import algorithm.problem.baekjoon.recursion.P2447;

public class S2447 implements P2447 {
	// https://da9dac.tistory.com/206

	private static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		arr = new char[n][n];

		createStar(0, 0, n, false);

		for (char[] a : arr){
			bw.write(a);
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}

	private static void createStar(int x, int y, int size, boolean jump) {
		if (jump) {
			for (int i = x; i < x + size; i++) {
				for (int j = y; j < y + size; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}

		if (size == 1) {
			arr[x][y] = '*';
			return;
		}

		int newSize = size / 3;

		for (int i = x; i < size + x; i += newSize) {
			for (int j = y; j < size + y; j += newSize){
				if (i == (x + newSize) && j == (y + newSize)) {
					createStar(i, j, newSize, true);
				} else {
					createStar(i, j, newSize, false);
				}
			}
		}
	}
}
