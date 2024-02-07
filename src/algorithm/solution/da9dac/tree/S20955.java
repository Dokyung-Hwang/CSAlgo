package algorithm.solution.da9dac.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.tree.P20955;

public class S20955 implements P20955 {
	// https://da9dac.tistory.com/307

	private static int node, edge;
	private static boolean[] isVisited;
	private static final ArrayList<ArrayList<Integer>> near = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x, y;
		int cut = 0;
		int tree = 0;

		isVisited = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			near.add(new ArrayList<>());
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			near.get(x).add(y);
			near.get(y).add(x);
		}

		for (int i = 1; i <= n; i++) {
			if (isVisited[i]) continue;
			tree++;
			node = edge = 0;
			dfs(i);
			if (edge != (node - 1) * 2) {
				cut += (edge - ((node - 1) * 2))/2;
			}
		}

		System.out.println(cut + tree - 1);
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
