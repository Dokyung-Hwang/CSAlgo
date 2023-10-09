package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

import algorithm.problem.bfs.P7576;

public class S7576 implements P7576 {
	// https://da9dac.tistory.com/190

	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] tomato = new int[n][m];

		Queue<Pair> queue = new ArrayDeque<>();
		int[][] day = new int[n][m];

		int target = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				int t = Integer.parseInt(st.nextToken());
				tomato[i][j] = t;
				if (t == 1) {
					queue.offer(new Pair(i, j));
					day[i][j] = 1;
				} else if (t == 0) {
					target++;
				}
			}
		}

		if (target == 0) {
			System.out.println(0);
			return;
		}

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (day[nx][ny] > 0 || tomato[nx][ny] == -1) continue;

				target--;
				if (target == 0) {
					System.out.println(day[cur.x][cur.y]);
					return;
				}
				day[nx][ny] = day[cur.x][cur.y] + 1;
				queue.offer(new Pair(nx, ny));
			}

		}

		System.out.println(-1);
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
