package algorithm.solution.da9dac.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.graph.P2617;

public class S2617 implements P2617 {

	private static int[][] near;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x, y;

		near = new int[n + 1][n + 1];

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			near[x][y] = 1;
			near[y][x] = -1;
		}

		for (int i = 1; i <= n; i++) {
			dfs(i);
		}
	}

	private static void dfs(int cur) {

	}
}
