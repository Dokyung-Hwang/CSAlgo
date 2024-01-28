package algorithm.solution.da9dac.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.tree.P15681;

public class S15681 implements P15681 {
	// https://da9dac.tistory.com/305

	private static final ArrayList<ArrayList<Integer>> near = new ArrayList<>();
	private static int[] counts;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int x, y;

		counts = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			near.add(new ArrayList<>());
		}

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			near.get(x).add(y);
			near.get(y).add(x);
		}

		travel(r);

		while (q-- > 0) {
			sb.append(counts[Integer.parseInt(br.readLine())]).append("\n");
		}

		System.out.println(sb);
	}

	private static void travel(int cur) {
		counts[cur] = 1;

		for (int next : near.get(cur)) {
			if (counts[next] != 0) continue;
			travel(next);
			counts[cur] += counts[next];
		}
	}
}
