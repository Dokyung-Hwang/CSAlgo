package algorithm.solution.da9dac.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.simulation.P18808;

public class S18808 implements P18808 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] notebook = new int[n][m];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			int[][] sticker = new int[r][c];

			for (int j = 0; j < r; j++) {
				st = new StringTokenizer(br.readLine());

				for (int l = 0; l < c; l++) {
					sticker[j][l] = Integer.parseInt(st.nextToken());
				}
			}

			int angle = 0;
			int x = 0;
			int y = 0;

			while (angle <= 270) {
				int height = n;
				int length = m;

				for (int j = 0; j < n; j++) {

				}

				

				angle += 90;
			}
		}
	}
}
