package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.bfs.P9466;

public class S9466 implements P9466 {
	// https://da9dac.tistory.com/243

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int count = n;
			st = new StringTokenizer(br.readLine());

			int[]students = new int[n];
			int[] arr = new int[n];

			boolean[] isCycle = new boolean[n];
			boolean[] isNotCycle = new boolean[n];

			for (int j = 0; j < n; j++) {
				int select = Integer.parseInt(st.nextToken()) - 1;

				students[j] = select;

				if (j == select) {
					isCycle[j] = true;
					count--;
				}
			}

			for (int j = 0; j < n; j++) {
				if (isCycle[j] || isNotCycle[j]) continue;

				int select = students[j];

				arr[0] = j;

				int size = 1;

				while (true) {
					if (isCycle[select] || isNotCycle[select]) {
						for (int k = 0; k < size; k++) {
							isNotCycle[arr[k]] = true;
						}
						break;
					}

					if (j == select) {
						for (int k = 0; k < size; k++) {
							isCycle[arr[k]] = true;
						}
						count -= size;
						break;
					}

					if (size >= count) {
						isNotCycle[j] = true;
						break;
					}

					arr[size++] = select;
					select = students[select];
				}
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}
}
