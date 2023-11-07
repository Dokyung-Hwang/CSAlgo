package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.bfs.P7562;

public class S7562 implements P7562 {
	// https://da9dac.tistory.com/238

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int[] knightX = {2, 2, 1, 1, -1, -1, -2, -2};
		int[] knightY = {1, -1, 2, -2, 2, -2, 1, -1};

		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			int l = Integer.parseInt(br.readLine());
			boolean[][] isVisited = new boolean[l][l];

			st = new StringTokenizer(br.readLine(), " ");
			Knight now = new Knight(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

			st = new StringTokenizer(br.readLine(), " ");
			Knight target = new Knight(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

			Queue<Knight> knights = new LinkedList<>();
			knights.offer(now);
			isVisited[now.x][now.y] = true;

			if (now.x == target.x && now.y == target.y) {
				sb.append(0).append("\n");
				continue;
			}

			out:
			while (!knights.isEmpty()) {
				Knight cur = knights.poll();

				for (int i = 0; i < 8; i++) {
					int x = cur.x + knightX[i];
					int y = cur.y + knightY[i];

					if (x < 0 || x >= l || y < 0 || y >= l) continue;
					if (isVisited[x][y]) continue;

					isVisited[x][y] = true;

					if (x == target.x && y == target.y) {
						sb.append(cur.moves + 1).append("\n");
						break out;
					}

					knights.offer(new Knight(x, y, cur.moves + 1));
				}
			}
		}

		System.out.println(sb);
	}

	private static class Knight {
		int x;
		int y;
		int moves;

		public Knight(int x, int y, int moves) {
			this.x = x;
			this.y = y;
			this.moves = moves;
		}
	}
}
