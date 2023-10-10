package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import algorithm.problem.bfs.P4179;

public class S4179 implements P4179 {
	// https://da9dac.tistory.com/191

	private static int[] dx = {1, 0, -1, 0};
	private static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int r = Integer.parseInt(st.nextToken()); // n
		int c = Integer.parseInt(st.nextToken()); // m

		char[][] maze = new char[r][c];
		int[][] fireDistances = new int[r][c];
		int[][] jihunDistances = new int[r][c];

		Queue<Pair> fireQueue = new ArrayDeque<>();
		Queue<Pair> jihunQueue = new ArrayDeque<>();

		for (int i = 0; i < r; i++) {
			char[] input = br.readLine().toCharArray();

			for (int j = 0; j < c; j++) {
				maze[i][j] = input[j];

				jihunDistances[i][j] = -1;
				fireDistances[i][j] = -1;

				if (input[j] == 'J') {
					jihunDistances[i][j] = 0;
					jihunQueue.offer(new Pair(i, j));
				} else if (input[j] == 'F') {
					fireDistances[i][j] = 0;
					fireQueue.offer(new Pair(i, j));
				}
			}
		}

		while (!fireQueue.isEmpty()) {
			Pair cur = fireQueue.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
				if (fireDistances[nx][ny] >= 0 || maze[nx][ny] == '#') continue;

				fireDistances[nx][ny] = fireDistances[cur.x][cur.y] + 1;
				fireQueue.offer(new Pair(nx, ny));
			}
		}

		while (!jihunQueue.isEmpty()) {
			Pair cur = jihunQueue.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
					System.out.println(jihunDistances[cur.x][cur.y] + 1);
					return;
				}
				if (jihunDistances[nx][ny] >= 0 || maze[nx][ny] == '#') continue;
				if (fireDistances[nx][ny] != -1 && jihunDistances[cur.x][cur.y] + 1 >= fireDistances[nx][ny]) continue;

				jihunDistances[nx][ny] = jihunDistances[cur.x][cur.y] + 1;
				jihunQueue.offer(new Pair(nx, ny));
			}
		}

		System.out.println("IMPOSSIBLE");
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
