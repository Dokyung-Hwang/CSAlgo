package algorithm.solution.da9dac.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.graph.P11403;

public class S11403 implements P11403 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[][] near = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= n; j++) {
				near[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				boolean[] isVisited = new boolean[n + 1];
				boolean isPossible = false;

				if (near[i][j] == 1) {
					sb.append("1").append(" ");
					continue;
				}

				q.offer(i);
				isVisited[i] = true;

				while (!q.isEmpty()) {
					int cur = q.poll();

					for (int k = 1; k <= n; k++) {
						if (near[cur][k] != 1) continue;
						if (k == j) {
							isPossible = true;
							break;
						}
						if (isVisited[k]) continue;

						q.offer(k);
						isVisited[k] = true;
					}

					if (isPossible) break;
				}

				if (isPossible) sb.append("1").append(" ");
				else sb.append("0").append(" ");

				q.clear();
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
