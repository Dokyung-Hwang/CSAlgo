package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.bfs.P5427;

public class S5427 implements P5427 {
	// https://da9dac.tistory.com/239

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			char[][] building = new char[h][w];

			boolean[][] isVisited = new boolean[h][w];
			int[][] isFired = new int[h][w];

			Queue<XY> sgs = new LinkedList<>();
			Queue<XY> fires = new LinkedList<>();

			XY sg;
			XY fire;

			for (int i = 0; i < h; i++) {
				char[] input = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					char c = input[j];
					if (c == '@') {
						sg = new XY(i, j, 1);
						sgs.offer(sg);
						isVisited[i][j] = true;
					} else if (c == '*') {
						fire = new XY(i, j, 1);
						fires.offer(fire);
						isFired[i][j] = 1;
					}
					building[i][j] = c;
				}
			}

			while (!fires.isEmpty()) {
				XY cur = fires.poll();

				for (int dir = 0; dir < 4; dir++) {
					int x = cur.x + dx[dir];
					int y = cur.y + dy[dir];

					if (x < 0 || x >= h || y < 0 || y >= w) continue;
					if (isFired[x][y] != 0 || building[x][y] == '#') continue;

					isFired[x][y] = cur.time + 1;
					fires.offer(new XY(x, y, cur.time + 1));
				}
			}

			boolean isPossible = false;

			out:
			while (!sgs.isEmpty()) {
				XY cur = sgs.poll();

				for (int dir = 0; dir < 4; dir++) {
					int x = cur.x + dx[dir];
					int y = cur.y + dy[dir];

					if (x < 0 || x >= h || y < 0 || y >= w) {
						sb.append(cur.time).append("\n");
						isPossible = true;
						break out;
					}
					if (isVisited[x][y] || building[x][y] == '#') continue;
					if (isFired[x][y] != 0 && isFired[x][y] - 1 < cur.time + 1) continue;

					isVisited[x][y] = true;
					sgs.offer(new XY(x, y, cur.time + 1));
				}
			}

			if (!isPossible) {
				sb.append("IMPOSSIBLE").append("\n");
			}
		}

		System.out.println(sb);
	}

	private static class XY {
		int x;
		int y;
		int time;

		public XY(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
}
