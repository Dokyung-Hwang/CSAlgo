package algorithm.solution.da9dac.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.simulation.P15683;

public class S15683 implements P15683 {
	// https://da9dac.tistory.com/256

	private static int n;
	private static int m;
	private static int size;
	private static int min = Integer.MAX_VALUE;

	private static int[][] office;
	private static int[][] isWatched;
	private static List<CCTV> cctvs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		office = new int[n][m];
		isWatched = new int[n][m];

		cctvs = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				office[i][j] = num;

				if (num == 6) isWatched[i][j] = 1;
				else if (num != 0) {
					cctvs.add(new CCTV(i, j));
				}
			}
		}

		size = cctvs.size();

		watch(0);

		System.out.println(min);
	}

	private static void watch(int idx) {
		if (idx == size) {
			int count = 0;
			for (int[] w : isWatched) {
				for (int b : w) {
					if (b == 0) count++;
				}
			}
			min = Math.min(min, count);
			return;
		}

		CCTV cur = cctvs.get(idx);
		int x = cur.x;
		int y = cur.y;
		int cctv = office[x][y];

		switch (cctv) {
			case 1: {
				up(idx, x, y);
				down(idx, x, y);
				left(idx, y, x);
				right(idx, y, x);
				break;
			}
			case 2: {
				height(idx, x, y);
				width(idx, y, x);
				break;
			}
			case 3: {
				upRight(idx, x, y);
				rightDown(idx, x, y);
				downLeft(idx, x, y);
				leftUp(idx, x, y);
				break;
			}
			case 4: {
				leftUpRight(idx, x, y);
				upRightDown(idx, x, y);
				rightDownLeft(idx, x, y);
				downLeftUp(idx, x, y);
				break;
			}
			case 5: {
				all(idx, x, y);
				break;
			}
		}
	}

	private static void right(int idx, int y, int x) {
		visitRigth(idx, y, x);

		watch(idx + 1);

		rollbackRight(idx, y, x);
	}

	private static void rollbackRight(int idx, int y, int x) {
		for (int j = y; j < m; j++) {
			if (office[x][j] == 6) break;
			if (isWatched[x][j] != idx + 1) continue;
			isWatched[x][j] = 0;
		}
	}

	private static void visitRigth(int idx, int y, int x) {
		for (int j = y; j < m; j++) {
			if (office[x][j] == 6) break;
			if (isWatched[x][j] != 0) continue;
			isWatched[x][j] = idx + 1;
		}
	}

	private static void left(int idx, int y, int x) {
		visitLeft(idx, y, x);

		watch(idx + 1);

		rollbackLeft(idx, y, x);
	}

	private static void rollbackLeft(int idx, int y, int x) {
		for (int j = y; j >= 0; j--) {
			if (office[x][j] == 6) break;
			if (isWatched[x][j] != idx + 1) continue;
			isWatched[x][j] = 0;
		}
	}

	private static void visitLeft(int idx, int y, int x) {
		for (int j = y; j >= 0; j--) {
			if (office[x][j] == 6) break;
			if (isWatched[x][j] != 0) continue;
			isWatched[x][j] = idx + 1;
		}
	}

	private static void down(int idx, int x, int y) {
		visitDown(idx, x, y);

		watch(idx + 1);

		rollbackDown(idx, x, y);
	}

	private static void rollbackDown(int idx, int x, int y) {
		for (int j = x; j < n; j++) {
			if (office[j][y] == 6) break;
			if (isWatched[j][y] != idx + 1) continue;
			isWatched[j][y] = 0;
		}
	}

	private static void visitDown(int idx, int x, int y) {
		for (int j = x; j < n; j++) {
			if (office[j][y] == 6) break;
			if (isWatched[j][y] != 0) continue;
			isWatched[j][y] = idx + 1;
		}
	}

	private static void up(int idx, int x, int y) {
		visitUp(idx, x, y);

		watch(idx + 1);

		rollbackUp(idx, x, y);
	}

	private static void rollbackUp(int idx, int x, int y) {
		for (int j = x; j >= 0; j--) {
			if (office[j][y] == 6) break;
			if (isWatched[j][y] != idx + 1) continue;
			isWatched[j][y] = 0;
		}
	}

	private static void visitUp(int idx, int x, int y) {
		for (int j = x; j >= 0; j--) {
			if (office[j][y] == 6) break;
			if (isWatched[j][y] != 0) continue;
			isWatched[j][y] = idx + 1;
		}
	}

	private static void all(int idx, int x, int y) {
		visitLeft(idx, y, x);
		visitUp(idx, x, y);
		visitRigth(idx, y, x);
		visitDown(idx, x, y);

		watch(idx + 1);

		rollbackLeft(idx, y, x);
		rollbackUp(idx, x, y);
		rollbackRight(idx, y, x);
		rollbackDown(idx, x, y);
	}
	private static void leftUpRight(int idx, int x, int y) {
		visitLeft(idx, y, x);
		visitUp(idx, x, y);
		visitRigth(idx, y, x);

		watch(idx + 1);

		rollbackLeft(idx, y, x);
		rollbackUp(idx, x, y);
		rollbackRight(idx, y, x);
	}

	private static void upRightDown(int idx, int x, int y) {
		visitUp(idx, x, y);
		visitRigth(idx, y, x);
		visitDown(idx, x, y);

		watch(idx + 1);

		rollbackUp(idx, x, y);
		rollbackRight(idx, y, x);
		rollbackDown(idx, x, y);
	}

	private static void rightDownLeft(int idx, int x, int y) {
		visitRigth(idx, y, x);
		visitDown(idx, x, y);
		visitLeft(idx, y, x);

		watch(idx + 1);

		rollbackRight(idx, y, x);
		rollbackDown(idx, x, y);
		rollbackLeft(idx, y, x);
	}

	private static void downLeftUp(int idx, int x, int y) {
		visitDown(idx, x, y);
		visitLeft(idx, y, x);
		visitUp(idx, x, y);

		watch(idx + 1);

		rollbackDown(idx, x, y);
		rollbackLeft(idx, y, x);
		rollbackUp(idx, x, y);
	}

	private static void width(int idx, int y, int x) {
		visitRigth(idx, y, x);
		visitLeft(idx, y, x);

		watch(idx + 1);

		rollbackRight(idx, y, x);
		rollbackLeft(idx, y, x);
	}

	private static void height(int idx, int x, int y) {
		visitUp(idx, x, y);
		visitDown(idx, x, y);

		watch(idx + 1);

		rollbackUp(idx, x, y);
		rollbackDown(idx, x, y);
	}

	private static void upRight(int idx, int x, int y) {
		visitUp(idx, x, y);
		visitRigth(idx, y, x);

		watch(idx + 1);

		rollbackUp(idx, x, y);
		rollbackRight(idx, y, x);
	}

	private static void rightDown(int idx, int x, int y) {
		visitRigth(idx, y, x);
		visitDown(idx, x, y);

		watch(idx + 1);

		rollbackRight(idx, y, x);
		rollbackDown(idx, x, y);
	}
	private static void downLeft(int idx, int x, int y) {
		visitDown(idx, x, y);
		visitLeft(idx, y, x);

		watch(idx + 1);

		rollbackDown(idx, x, y);
		rollbackLeft(idx, y, x);
	}

	private static void leftUp(int idx, int x, int y) {
		visitLeft(idx, y, x);
		visitUp(idx, x, y);

		watch(idx + 1);

		rollbackLeft(idx, y, x);
		rollbackUp(idx, x, y);
	}

	private static class CCTV {
		int x;
		int y;

		public CCTV(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
