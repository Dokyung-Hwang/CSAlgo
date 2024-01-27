package algorithm.solution.da9dac.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.tree.P11725;

public class S11725 implements P11725 {
	// https://da9dac.tistory.com/303

	private static int n;
	private static int[] p;
	private static final ArrayList<ArrayList<Integer>> nearList = new ArrayList<>();
	private static StringTokenizer st;
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		input();
		bfs();
		dfs(1, 0);
		append();
		System.out.println(sb);
	}

	private static void bfs() {
		p = new int[n + 1];

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : nearList.get(cur)) {
				if (p[cur] == next) continue;
				q.offer(next);
				p[next] = cur;
			}
		}

		sb.append("BFS").append("\n");

		append();

		sb.append("\n");
		sb.append("DFS").append("\n");
		p = new int[n + 1];
	}

	private static void dfs(int cur, int parent) {
		p[cur] = parent;

		for (int next : nearList.get(cur)) {
			if (p[cur] == next) continue;
			dfs(next, cur);
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		int x, y;

		for (int i = 0; i <= n; i++) {
			nearList.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			nearList.get(x).add(y);
			nearList.get(y).add(x);
		}
	}

	private static void append() {
		for (int i = 2; i <= n; i++) {
			sb.append(p[i]).append("\n");
		}
	}
}
