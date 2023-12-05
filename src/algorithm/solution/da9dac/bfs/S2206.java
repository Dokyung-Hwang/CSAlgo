package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import algorithm.problem.baekjoon.bfs.P2206;

public class S2206 implements P2206 {
	// https://da9dac.tistory.com/242

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);


		int[][] arr = new int[n][m];
		boolean[][] isVisited = new boolean[n][m];
		boolean[][] isBrokenVisited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				arr[i][j] = input[j] - '0';
			}
		}

		if (n == 1 && m == 1) {
			System.out.println(1);
			return;
		}

		Queue<XY> queue = new LinkedList<>();

		queue.offer(new XY(0, 0, 1, false));
		isVisited[0][0] = true;
		isBrokenVisited[0][0] = true;

		while (!queue.isEmpty()) {
			XY cur = queue.poll();

			for (int dir = 0; dir < 4; dir++) {
				int x = dx[dir] + cur.x;
				int y = dy[dir] + cur.y;

				if (x < 0 || x >= n || y < 0 || y >= m) continue;
				if (isVisited[x][y] || (cur.isBroken && (arr[x][y] == 1 || isBrokenVisited[x][y]))) continue;

				if (x + 1 == n && y + 1 == m) {
					System.out.println(cur.moves + 1);
					return;
				}

				XY newXY = new XY(x, y, cur.moves + 1, cur.isBroken);

				if (cur.isBroken) {
					isBrokenVisited[x][y] = true;
				} else {
					isVisited[x][y] = true;
					if (arr[x][y] == 1)  {
						isBrokenVisited[x][y] = true;
						newXY.isBroken = true;
					}
				}

				queue.offer(newXY);
			}
		}

		System.out.println(-1);
	}

	private static class XY {
		int x;
		int y;
		int moves;
		boolean isBroken;

		public XY(int x, int y, int moves, boolean isBroken) {
			this.x = x;
			this.y = y;
			this.moves = moves;
			this.isBroken = isBroken;
		}
	}
}
