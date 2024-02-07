package algorithm.solution.da9dac.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.tree.P4803;

public class S4803 implements P4803 {
	// https://da9dac.tistory.com/304

	private static int cnt, node, edge;
	private static ArrayList<ArrayList<Integer>> near;
	private static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int c = 1, n, m, x, y;

		while (true) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			if (n + m == 0) break;

			cnt = 0;
			near = new ArrayList<>();
			isVisited = new boolean[n + 1];

			for (int i = 0; i <= n; i++) {
				near.add(new ArrayList<>());
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());

				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());

				near.get(x).add(y);
				near.get(y).add(x);
			}

			for (int i = 1; i <= n; i++) {
				if (isVisited[i]) continue;
				node = 0;
				edge = 0;
				dfs(i);
				if (edge == (node - 1) * 2) cnt++;
			}

			sb.append("Case ").append(c++).append(": ");

			if (cnt == 0) sb.append("No trees.");
			else if (cnt == 1) sb.append("There is one tree.");
			else sb.append("A forest of ").append(cnt).append(" trees.");

			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int cur) {
		isVisited[cur] = true;
		node++;

		for (int next : near.get(cur)) {
			edge++;
			if (isVisited[next]) continue;
			dfs(next);
		}
	}
}
