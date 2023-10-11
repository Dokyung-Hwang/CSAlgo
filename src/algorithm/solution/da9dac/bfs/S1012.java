package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import algorithm.problem.bfs.P1012;

public class S1012 implements P1012 {
	// https://da9dac.tistory.com/193

	private static StringTokenizer st;
	private static int m;
	private static int n;
	private static int cabbage;
	private static int[][] field;
	private static boolean[][] isVisited;
	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			cabbage = Integer.parseInt(st.nextToken());

			field = new int[n][m];
			isVisited = new boolean[n][m];

			for (int j = 0; j < cabbage; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				field[y][x] = 1;
			}

			Queue<Pair> queue = new ArrayDeque<>();

			int count = 0;

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (field[j][k] == 0 || isVisited[j][k]) continue;

					count++;
					queue.offer(new Pair(j, k));
					isVisited[j][k] = true;

					while (!queue.isEmpty()) {
						Pair cur = queue.poll();

						for (int dir = 0; dir < 4; dir++) {
							int nx = cur.x + dx[dir];
							int ny = cur.y + dy[dir];

							if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
							if (isVisited[nx][ny] || field[nx][ny] == 0) continue;

							queue.offer(new Pair(nx, ny));
							isVisited[nx][ny] = true;
						}
					}
				}
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}

	private static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
