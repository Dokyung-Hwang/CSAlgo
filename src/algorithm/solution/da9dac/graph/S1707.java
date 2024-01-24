package algorithm.solution.da9dac.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.graph.P1707;

public class S1707 implements P1707 {
	// https://da9dac.tistory.com/300

	private static int v, e, x, y;
	private static ArrayList<ArrayList<Integer>> near;
	private static int[] paint;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());

			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			near = new ArrayList<>();
			paint = new int[v + 1];
			boolean isBipartite = true;

			for (int i = 0; i <= v; i++) {
				near.add(new ArrayList<>());
			}

			while (e-- > 0) {
				st = new StringTokenizer(br.readLine());

				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());

				near.get(x).add(y);
				near.get(y).add(x);
			}

			for (int i = 1; i <= v; i++) {
				if (paint[i] != 0) continue;
				if (!dfs(i, -1)) {
					isBipartite = false;
					break;
				}
			}

			if (isBipartite) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}

		System.out.println(sb);
	}

	private static boolean dfs(int cur, int prev) {
		int color = -(prev);
		paint[cur] = color;

		for (int next : near.get(cur)) {
			if (paint[next] == color) return false;
			else if (paint[next] == -color) continue;
			if (!dfs(next, color)) return false;
		}

		return true;
	}
}
