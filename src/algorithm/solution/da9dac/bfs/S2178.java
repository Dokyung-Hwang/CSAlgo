package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import algorithm.problem.bfs.P2178;

public class S2178 implements P2178 {
	// https://da9dac.tistory.com/186

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] maze = new int[n][m];
		boolean[][] isVisited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");

			for (int j = 0; j < m; j++) {
				maze[i][j] = Integer.parseInt(input[j]);
			}
		}

		Queue<Pair> queue = new ArrayDeque<>();

		isVisited[0][0] = true;
		queue.offer(new Pair(0, 0, 1));

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			if (cur.x == n - 1 && cur.y == m - 1) {
				System.out.println(cur.distance);
				break;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (maze[nx][ny] == 0 || isVisited[nx][ny])
					continue;

				isVisited[nx][ny] = true;
				queue.offer(new Pair(nx, ny, cur.distance + 1));
			}
		}
	}

	private static class Pair {
		int x;
		int y;
		int distance;

		public Pair(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}
}
