package algorithm.solution.da9dac.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.graph.P5567;

public class S5567 implements P5567 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int cnt = 0;

		int[] friends = new int[n + 1];

		ArrayList<ArrayList<Integer>> nearList = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			friends[i] = -1;
			nearList.add(new ArrayList<>());
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			nearList.get(x).add(y);
			nearList.get(y).add(x);
		}

		Queue<Integer> q = new ArrayDeque<>();

		q.offer(1);
		friends[1] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();
			int f = friends[cur];

			for (int next : nearList.get(cur)) {
				if (friends[next] != -1) continue;
				if (f + 1 > 2) continue;

				q.offer(next);
				friends[next] = f + 1;
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
