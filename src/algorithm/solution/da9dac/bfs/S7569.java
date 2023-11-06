package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

import algorithm.problem.baekjoon.bfs.P7569;

public class S7569 implements P7569 {
	// https://da9dac.tistory.com/237

	private static int[] dx = {1, -1, 0, 0, 0, 0};
	private static int[] dy = {0, 0, 1, -1, 0, 0};
	private static int[] dz = {0, 0, 0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] mnh = br.readLine().split(" ");

		int m = Integer.parseInt(mnh[0]);
		int n = Integer.parseInt(mnh[1]);
		int h = Integer.parseInt(mnh[2]);

		int[][][] box = new int[h][n][m];
		boolean[][][] isVisited = new boolean[h][n][m];

		Queue<XYZ> queue = new ArrayDeque<>();

		int unripe = 0;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				String[] input = br.readLine().split(" ");
				for (int k = 0; k < m; k++) {
					int tomato = Integer.parseInt(input[k]);
					box[i][j][k] = tomato;

					if (tomato == 0) unripe++;

					if (tomato == 1) {
						queue.offer(new XYZ(i, j, k, 0));
						isVisited[i][j][k] = true;
					}
				}
			}
		}

		if (unripe == 0) {
			System.out.println(0);
			return;
		}

		while (!queue.isEmpty()) {
			XYZ cur = queue.poll();

			for (int i = 0; i < 6; i++) {
				int x = cur.x + dx[i];
				int y = cur.y + dy[i];
				int z = cur.z + dz[i];

				if (x < 0 || x >= n || y < 0 || y >= m || z < 0 || z >= h) continue;
				if (isVisited[z][x][y] || box[z][x][y] == -1) continue;

				unripe--;

				if (unripe == 0) {
					System.out.println(cur.day + 1);
					return;
				}

				isVisited[z][x][y] = true;
				queue.offer(new XYZ(z, x, y, cur.day + 1));
			}
		}

		System.out.println(-1);
	}

	private static class XYZ {
		private int z;
		private int x;
		private int y;
		private int day;

		public XYZ(int z, int x, int y, int day) {
			this.z = z;
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
}
