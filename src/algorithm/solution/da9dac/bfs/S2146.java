package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.bfs.P2146;

public class S2146 implements P2146 {
	// https://da9dac.tistory.com/245

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		int n = Integer.parseInt(br.readLine());

		int[][] maps = new int[n][n];
		boolean[][] isVisited = new boolean[n][n];
		boolean[][] isWall = new boolean[n][n];

		int count = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				maps[i][j] = num;
				count = Math.max(count, num);
			}
		}

		int area = 1;
		Queue<Continent> continents;
		Queue<Continent> walls = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!isVisited[i][j] && maps[i][j] == 1) {
					continents = new LinkedList<>();
					continents.offer(new Continent(i, j));
					isVisited[i][j] = true;
					maps[i][j] = area;

					while (!continents.isEmpty()) {
						Continent cur = continents.poll();

						for (int dir = 0; dir < 4; dir++) {
							int x = cur.x + dx[dir];
							int y = cur.y + dy[dir];

							if (x < 0 || x >= n || y < 0 || y >= n) continue;
							if (isVisited[x][y]) continue;
							if (maps[x][y] == 0) {
								if (!isWall[cur.x][cur.y]) {
									isWall[cur.x][cur.y] = true;
									walls.offer(cur);
								}
								continue;
							}

							isVisited[x][y] = true;
							maps[x][y] = area;
							continents.offer(new Continent(x, y));
						}
					}

					area++;
				}
			}
		}

		int distance = Integer.MAX_VALUE;
		Queue<Continent> queue;

		while (!walls.isEmpty()) {
			Continent wall = walls.poll();
			int continent = maps[wall.x][wall.y];
			queue = new LinkedList<>();
			isVisited = new boolean[n][n];
			wall.dist = 0;
			queue.offer(wall);
			isVisited[wall.x][wall.y] = true;

			while (!queue.isEmpty()) {
				Continent cur = queue.poll();

				for (int dir = 0; dir < 4; dir++) {
					int x = cur.x + dx[dir];
					int y = cur.y + dy[dir];

					if (x < 0 || x >= n || y < 0 || y >= n) continue;

					int next = maps[x][y];
					if (next == continent || isVisited[x][y]) continue;
					if (next != 0) {
						distance = Math.min(distance, cur.dist);
						continue;
					}
					if (cur.dist >= distance) {
						isVisited[x][y] = true;
						continue;
					}

					isVisited[x][y] = true;
					queue.offer(new Continent(x, y, cur.dist + 1));
				}
			}

		}
		System.out.println(distance);
	}

	private static class Continent {
		int x;
		int y;
		int dist;

		public Continent(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Continent(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
}
