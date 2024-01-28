package algorithm.solution.da9dac.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.tree.P1240;

public class S1240 implements P1240 {
	// https://da9dac.tistory.com/306

	private static int start, end, result;
	private static boolean[] isVisited;
	private static final ArrayList<ArrayList<Pair>> near = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x, y, d;

		for (int i = 0; i <= n; i++) {
			near.add(new ArrayList<>());
		}

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			near.get(x).add(new Pair(y, d));
			near.get(y).add(new Pair(x, d));
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());

			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			isVisited = new boolean[n + 1];

			dfs(start, 0);
			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int cur, int move) {
		isVisited[cur] = true;

		for (Pair pair : near.get(cur)) {
			if (isVisited[pair.node]) continue;
			if (pair.node == end) {
				result = move + pair.dist;
				return;
			}
			dfs(pair.node, move + pair.dist);
		}
	}

	private static class Pair {
		int node;
		int dist;

		public Pair(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}
}
