package algorithm.solution.da9dac.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.graph.P2606;

public class S2606 implements P2606 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int cnt = 0;

		ArrayList<ArrayList<Integer>> nearList = new ArrayList<>();
		Queue<Integer> q = new ArrayDeque<>();

		boolean[] isVisited = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			nearList.add(new ArrayList<>());
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			nearList.get(x).add(y);
			nearList.get(y).add(x);
		}

		q.offer(1);
		isVisited[1] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : nearList.get(cur)) {
				if (isVisited[next]) continue;
				q.offer(next);
				isVisited[next] = true;
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
