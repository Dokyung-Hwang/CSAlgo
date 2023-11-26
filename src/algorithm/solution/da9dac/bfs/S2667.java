package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algorithm.problem.baekjoon.bfs.P2667;

public class S2667 implements P2667 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[][] apart = new int[n][n];
		boolean[][] isVisited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				apart[i][j] = input[j] - '0';
			}
		}

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		int num = 0;

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (apart[i][j] == 0 || isVisited[i][j]) continue;

				int count = 1;
				Queue<Pair> queue = new LinkedList<>();
				queue.offer(new Pair(i, j));
				isVisited[i][j] = true;

				while (!queue.isEmpty()) {
					Pair cur = queue.poll();

					for (int dir = 0; dir < 4; dir++) {
						int x = cur.x + dx[dir];
						int y = cur.y + dy[dir];

						if (x < 0 || x >= n || y < 0 || y >= n) continue;
						if (apart[x][y] == 0 || isVisited[x][y]) continue;

						queue.offer(new Pair(x, y));
						isVisited[x][y] = true;
						count++;
					}
				}

				list.add(count);
				num++;
			}
		}

		sb.append(num).append("\n");
		list.sort(Comparator.naturalOrder());
		for (int i : list) {
			sb.append(i).append("\n");
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
