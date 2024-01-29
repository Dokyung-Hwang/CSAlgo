package algorithm.solution.da9dac.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.tree.P14267;

public class S14267 implements P14267 {
	// https://da9dac.tistory.com/308

	private static final ArrayList<ArrayList<Integer>> near = new ArrayList<>();
	private static int[] compliments;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int p;
		compliments = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			near.add(new ArrayList<>());
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			p = Integer.parseInt(st.nextToken());
			if (p == -1) continue;

			near.get(p).add(i);
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());

			compliments[Integer.parseInt(st.nextToken())] += Integer.parseInt(st.nextToken());
		}

		dfs(1);

		for (int i = 1; i <= n; i++) {
			sb.append(compliments[i]).append(" ");
		}

		System.out.println(sb);
	}

	private static void dfs(int cur) {
		for (int next : near.get(cur)) {
			compliments[next] += compliments[cur];
			dfs(next);
		}
	}
}
