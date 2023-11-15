package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.bfs.P2573;

public class S2573 implements P2573 {
	// https://da9dac.tistory.com/244

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Queue<Iceberg> icebergs = new LinkedList<>();

		int[][] north = new int[n][m];
		int[][] times = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				int sea = Integer.parseInt(st.nextToken());
				times[i][j] = -1;
				north[i][j] = sea;

				if (sea != 0) {
					icebergs.offer(new Iceberg(i, j, 0));
				}
			}
		}

		int start = 0;
		Queue<Iceberg> queue = new LinkedList<>();

		while (!icebergs.isEmpty()) {
			Iceberg cur = icebergs.poll();
			int cx = cur.x;
			int cy = cur.y;
			int time = cur.time;
			times[cx][cy] = time;

			if (start != time) {
				start = time;

				int count = icebergs.size();
				boolean[][] isVisited = new boolean[n][m];

				queue.offer(cur);
				isVisited[cx][cy] = true;

				while (!queue.isEmpty()) {
					Iceberg iceberg = queue.poll();
					int ix = iceberg.x;
					int iy = iceberg.y;

					for (int dir = 0; dir < 4; dir++) {
						int x = ix + dx[dir];
						int y = iy + dy[dir];

						if (x < 0 || x >= n || y < 0 || y >= m) continue;
						if (north[x][y] < 1 || isVisited[x][y]) continue;

						isVisited[x][y] = true;
						queue.offer(new Iceberg(x, y, 0));
						count--;
					}
				}

				if (count != 0) {
					System.out.println(time);
					return;
				}
			}

			for (int dir = 0; dir < 4; dir++) {
				int x = cx + dx[dir];
				int y = cy + dy[dir];

				if (x < 0 || x >= n || y < 0 || y >= m) continue;
				if (times[x][y] <= time && north[x][y] == 0 && north[cx][cy] > 0)
					north[cx][cy]--;

			}

			cur.time++;
			if (north[cx][cy] != 0) {
				icebergs.offer(cur);
			}
			times[cx][cy] = cur.time;
		}

		System.out.println(0);
	}

	private static class Iceberg {
		int x;
		int y;
		int time;

		public Iceberg(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
}
