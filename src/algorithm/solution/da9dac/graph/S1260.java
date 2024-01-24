package algorithm.solution.da9dac.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.graph.P1260;

public class S1260 implements P1260 {
	// https://da9dac.tistory.com/298

	private static int n;
	private static int[][] nearArr;
	private static boolean[] isVisited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		isVisited = new boolean[n + 1];
		nearArr = new int[n + 1][n + 1];

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			nearArr[x][y] = 1;
			nearArr[y][x] = 1;
		}

		dfs(v);
		sb.append("\n");

		bfs(v);

		System.out.println(sb);
	}

	private static void bfs(int start) {
		isVisited = new boolean[n + 1];

		Queue<Integer> q = new ArrayDeque<>();

		q.offer(start);
		isVisited[start] = true;
		sb.append(start).append(" ");

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 1; i <= n; i++) {
				if (isVisited[i] || nearArr[cur][i] != 1) continue;
				q.offer(i);
				isVisited[i] = true;
				sb.append(i).append(" ");
			}
		}
	}

	private static void dfs(int cur) {
		isVisited[cur] = true;
		sb.append(cur).append(" ");

		for (int i = 1; i <= n; i++) {
			if (isVisited[i] || nearArr[cur][i] != 1) continue;
			dfs(i);
		}
	}
}
