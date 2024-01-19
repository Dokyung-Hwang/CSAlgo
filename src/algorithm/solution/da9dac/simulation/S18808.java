package algorithm.solution.da9dac.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.simulation.P18808;

public class S18808 implements P18808 {
	// https://da9dac.tistory.com/289

	private static int n;
	private static int m;
	private static int r;
	private static int c;
	private static int[][] sticker;
	private static int[][] notebook;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int result = 0;

		notebook = new int[n][m];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());

			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			sticker = new int[r][c];

			int plus = 0;

			for (int j = 0; j < r; j++) {
				st = new StringTokenizer(br.readLine());

				for (int l = 0; l < c; l++) {
					int num = Integer.parseInt(st.nextToken());
					sticker[j][l] = num;
					if (num == 1) plus++;
				}
			}

			if (stick()) result += plus;
		}

		System.out.println(result);
	}

	private static boolean stick() {
		for (int rota = 0; rota < 4; rota++) {
			if (rota % 2 == 0) {
				for (int i = 0; i <= n - r; i++) {
					for (int j = 0; j <= m - c; j++) {
						if (rotation(rota, i, j)) return true;
					}
				}
			} else {
				for (int i = 0; i <= n - c; i++) {
					for (int j = 0; j <= m - r; j++) {
						if (rotation(rota, i, j)) return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean rotation(int rota, int st, int ed) {
		int a = 0;
		if (rota == 0) {
			for (int i = 0; i < r; i++) {
				int b = 0;
				for (int j = 0; j < c; j++) {
					if (sticker[i][j] == 1 && notebook[st + a][ed + b] == 1) return false;
					b++;
				}
				a++;
			}
			paste(rota, st, ed);
		} else if (rota == 1) {
			for (int i = 0; i < c; i++) {
				int b = 0;
				for (int j = r - 1; j >= 0; j--) {
					if (sticker[j][i] == 1 && notebook[st + a][ed + b] == 1) return false;
					b++;
				}
				a++;
			}
			paste(rota, st, ed);
		} else if (rota == 2) {
			for (int i = r - 1; i >= 0; i--) {
				int b = 0;
				for (int j = c - 1; j >= 0; j--) {
					if (sticker[i][j] == 1 && notebook[st + a][ed + b] == 1) return false;
					b++;
				}
				a++;
			}
			paste(rota, st, ed);
		} else {
			for (int i = c - 1; i >= 0; i--) {
				int b = 0;
				for (int j = 0; j < r; j++) {
					if (sticker[j][i] == 1 && notebook[st + a][ed + b] == 1) return false;
					b++;
				}
				a++;
			}
			paste(rota, st, ed);
		}

		return true;
	}

	private static void paste(int rota, int st, int ed) {
		if (rota == 0) {
			for (int i = 0; i < r; i++) {
				int b = 0;
				for (int j = 0; j < c; j++) {
					if (sticker[i][j] == 1) notebook[st][ed + b] = 1;
					b++;
				}
				st++;
			}
		} else if (rota == 1) {
			for (int i = 0; i < c; i++) {
				int b = 0;
				for (int j = r - 1; j >= 0; j--) {
					if (sticker[j][i] == 1) notebook[st][ed + b] = 1;
					b++;
				}
				st++;
			}
		} else if (rota == 2) {
			for (int i = r - 1; i >= 0; i--) {
				int b = 0;
				for (int j = c - 1; j >= 0; j--) {
					if (sticker[i][j] == 1) notebook[st][ed + b] = 1;
					b++;
				}
				st++;
			}
		} else {
			for (int i = c - 1; i >= 0; i--) {
				int b = 0;
				for (int j = 0; j < r; j++) {
					if (sticker[j][i] == 1) notebook[st][ed + b] = 1;
					b++;
				}
				st++;
			}
		}
	}
}
