package algorithm.solution.da9dac.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.graph.P2617;

public class S2617 implements P2617 {
	// https://da9dac.tistory.com/301

	private static int n;
	private static int next;
	private static int[][] near;
	private static int[][] count;
	private static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		near = new int[n + 1][n + 1];
		count = new int[n + 1][2];

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			near[x][y] = 1;
			near[y][x] = -1;
		}

		for (int i = 1; i <= n; i++) {
			isVisited = new boolean[n + 1];
			dfs(i, i, 0);
		}

		int max = 0;
		int mid = (n + 1) / 2;

		for (int i = 1; i <= n; i++) {
			if(count[i][0] >= mid || count[i][1] >= mid) max++;
		}

		System.out.println(max);
	}



	private static void dfs(int start, int cur, int x) {
		isVisited[cur] = true;
		if(x != 0) count[start][x == 1 ? 0 : 1]++;

		for (int i = 1; i <= n; i++) {
			next = near[cur][i];
			if (isVisited[i] || next == 0) continue;
			if (x != 0 && next != x) continue;
			dfs(start, i, next);
		}
	}
}
