package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.bfs.P7569;

public class S7569 implements P7569 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] mnh = br.readLine().split(" ");

		int m = Integer.parseInt(mnh[0]);
		int n = Integer.parseInt(mnh[1]);
		int h = Integer.parseInt(mnh[2]);

		int[][][] box = new int[h][n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {

				}
			}
		}
	}
}
