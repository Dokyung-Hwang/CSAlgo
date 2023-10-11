package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

import algorithm.problem.bfs.P10026;

public class S10026 implements P10026 {
	// https://da9dac.tistory.com/194

	private static final int[] dx = {1, 0, -1, 0};
	private static final int[] dy = {0, 1, 0, -1};
	private static final char[] rgbColor = {'R', 'G', 'B'};
	private static final char[] gbColor = {'G', 'B'};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[][] rgbGrid = new char[n][n];
		char[][] gbGrid = new char[n][n];

		boolean[][] rgbIsVisited = new boolean[n][n];
		boolean[][] gbIsVisited = new boolean[n][n];

		int rgb = 0;
		int gb = 0;

		Queue<Pair> rgbQueue = new ArrayDeque<>();
		Queue<Pair> gbQueue = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				rgbGrid[i][j] = input[j];
				if (input[j] == 'R') {
					gbGrid[i][j] = 'G';
				} else {
					gbGrid[i][j] = input[j];
				}
			}
		}

		for (char c : rgbColor){
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (rgbIsVisited[i][j] || rgbGrid[i][j] != c)
						continue;

					rgb++;
					rgbQueue.offer(new Pair(i, j));
					rgbIsVisited[i][j] = true;

					while (!rgbQueue.isEmpty()) {
						Pair cur = rgbQueue.poll();

						for (int dir = 0; dir < 4; dir++) {
							int nx = cur.x + dx[dir];
							int ny = cur.y + dy[dir];

							if (nx < 0 || nx >= n || ny < 0 || ny >= n)
								continue;
							if (rgbIsVisited[nx][ny] || rgbGrid[nx][ny] != c)
								continue;

							rgbQueue.offer(new Pair(nx, ny));
							rgbIsVisited[nx][ny] = true;
						}
					}
				}
			}
		}

		for (char c : gbColor){
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (gbIsVisited[i][j] || gbGrid[i][j] != c)
						continue;

					gb++;
					gbQueue.offer(new Pair(i, j));
					gbIsVisited[i][j] = true;

					while (!gbQueue.isEmpty()) {
						Pair cur = gbQueue.poll();

						for (int dir = 0; dir < 4; dir++) {
							int nx = cur.x + dx[dir];
							int ny = cur.y + dy[dir];

							if (nx < 0 || nx >= n || ny < 0 || ny >= n)
								continue;
							if (gbIsVisited[nx][ny] || gbGrid[nx][ny] != c)
								continue;

							gbQueue.offer(new Pair(nx, ny));
							gbIsVisited[nx][ny] = true;
						}
					}
				}
			}
		}

		System.out.println(rgb + " " + gb);
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
