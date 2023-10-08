package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

import algorithm.problem.bfs.P1926;

public class S1926 implements P1926 {
	// https://da9dac.tistory.com/184

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		int[][] painting = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");

			for (int j = 0; j < m; j++) {
				painting[i][j] = Integer.parseInt(input[j]);
			}
		}

		boolean[][] isVisited = new boolean[502][502];

		int max = 0;
		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (painting[i][j] == 0 || isVisited[i][j]) continue;
				count++;
				Queue<Pair> queue = new ArrayDeque<>();

				isVisited[i][j] = true;
				queue.offer(new Pair(i, j));

				int area = 0;

				while (!queue.isEmpty()) {
					area++;
					Pair cur = queue.poll();

					for (int dir = 0; dir < 4; dir++) {
						int nx = cur.x + dx[dir];
						int ny = cur.y + dy[dir];

						if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
						if (isVisited[nx][ny] || painting[nx][ny] != 1) continue;

						isVisited[nx][ny] = true;
						queue.offer(new Pair(nx, ny));
					}

					max = Math.max(max, area);
				}
			}
		}

		System.out.println(count + "\n" + max);
	}

	private static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
