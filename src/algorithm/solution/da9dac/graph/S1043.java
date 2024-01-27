package algorithm.solution.da9dac.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.graph.P1043;

public class S1043 implements P1043 {
	// https://da9dac.tistory.com/302

	private static ArrayList<ArrayList<Integer>> near = new ArrayList<>();
	private static boolean[] isTrue;
	private static boolean[] isUsed;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int s;
		int[] members;
		isTrue = new boolean[n + 1];
		isUsed = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			near.add(new ArrayList<>());
		}

		st = new StringTokenizer(br.readLine());

		int tr = Integer.parseInt(st.nextToken());
		int[] trs = new int[tr];
		ArrayList<int[]> parties = new ArrayList<>();

		for (int i = 0; i < tr; i++) {
			int people = Integer.parseInt(st.nextToken());
			trs[i] = people;
			isTrue[people] = true;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			s = Integer.parseInt(st.nextToken());
			members = new int[s];

			for (int j = 0; j < s; j++) {
				members[j] = Integer.parseInt(st.nextToken());
			}

			parties.add(members);

			for (int j = 0; j < s; j++) {
				ArrayList<Integer> list = near.get(members[j]);

				for (int k = 0; k < s; k++) {
					if (j != k) list.add(members[k]);
				}
			}
		}

		for (int i = 0; i < tr; i++) {
			dfs(trs[i]);
		}

		for (int[] party : parties) {
			for (int member : party) {
				if (isTrue[member]) {
					m--;
					break;
				}
			}
		}

		System.out.println(m);
	}

	private static void dfs(int cur) {
		isUsed[cur] = true;
		isTrue[cur] = true;

		for (int next : near.get(cur)) {
			if (isUsed[next]) continue;
			dfs(next);
		}
	}
}
