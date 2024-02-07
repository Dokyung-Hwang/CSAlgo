package algorithm.solution.da9dac.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.graph.P2660;

public class S2660 implements P2660 {
	// https://da9dac.tistory.com/299

	private static int n;
	private static int max;
	private static ArrayList<ArrayList<Integer>> near = new ArrayList<>();
	private static int[] scores;
	private static int[] friends;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		scores = new int[n + 1];
		friends = new int[n + 1];
		int min = n + 1;
		int count = 0;

		for (int i = 0; i <= n; i++) {
			near.add(new ArrayList<>());
		}

		while (true) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (x == y && x == -1) break;

			near.get(x).add(y);
			near.get(y).add(x);
		}

		for (int i = 1; i <= n; i++) {
			Arrays.fill(friends, -1);
			dfs(i, -1);
			max = 0;

			for (int j = 1; j <= n; j++) {
				max = Math.max(friends[j], max);
			}

			scores[i] = max;

			if (min > max) {
				count = 1;
				min = max;
			} else if (min == max) {
				count++;
			}
		}

		sb.append(min).append(" ").append(count).append("\n");
		for (int i = 1; i <= n; i++) {
			if (scores[i] == min) sb.append(i).append(" ");
		}

		System.out.println(sb);
	}

	private static void dfs(int cur, int prev) {
		int score = prev + 1;
		friends[cur] = score;

		for (int next : near.get(cur)) {
			if (friends[next] != -1) {
				if (friends[next] > score + 1) {
					dfs(next, score);
				}
				continue;
			}
			dfs(next, score);
		}
	}
}
