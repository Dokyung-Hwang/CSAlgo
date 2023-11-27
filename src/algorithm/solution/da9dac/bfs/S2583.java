package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.bfs.P2583;

public class S2583 implements P2583 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] paper = new int[m][n];
		boolean[][] isVisited = new boolean[m][n];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());

			int ay = Integer.parseInt(st.nextToken());
			int ax = Integer.parseInt(st.nextToken());
			int by = Integer.parseInt(st.nextToken());
			int bx = Integer.parseInt(st.nextToken());

			for (int j = ax; j < bx; j++) {
				for (int l = ay; l < by; l++) {
					paper[j][l] = 1;
				}
			}
		}

		List<Integer> list = new ArrayList<>();

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		int num = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (paper[i][j] == 1 || isVisited[i][j]) continue;

				Queue<Pair> q = new LinkedList<>();
				q.offer(new Pair(i, j));
				isVisited[i][j] = true;
				int count = 1;
				num++;

				while (!q.isEmpty()) {
					Pair cur = q.poll();

					for (int dir = 0; dir < 4; dir++) {
						int x = cur.x + dx[dir];
						int y = cur.y + dy[dir];

						if (x < 0 || x >= m || y < 0 || y >= n) continue;
						if (paper[x][y] == 1 || isVisited[x][y]) continue;

						q.offer(new Pair(x, y));
						isVisited[x][y] = true;
						count++;
					}
				}

				list.add(count);
			}
		}

		list.sort(Comparator.naturalOrder());

		sb.append(num).append("\n");
		for (int c : list) {
			sb.append(c).append(" ");
		}

		System.out.println(sb);
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
