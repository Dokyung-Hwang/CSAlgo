package algorithm.problem.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	static int[][] board = {
		{1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
		{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
		{1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
		{1, 1, 0, 0, 1, 0, 0, 0, 0, 0},
		{0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
	};

	static boolean[][] isVisited = new boolean[502][502];
	static int n = 7, m = 10;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		Queue<Pair> Q = new LinkedList<>();
		isVisited[0][0] = true;
		Q.add(new Pair(0, 0));

		while (!Q.isEmpty()) {
			Pair cur = Q.poll();
			System.out.print("(" + cur.x + ", " + cur.y + ") -> ");
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if (isVisited[nx][ny] || board[nx][ny] != 1) continue;
				isVisited[nx][ny] = true;
				Q.add(new Pair(nx, ny));
			}
		}
	}

	private static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
