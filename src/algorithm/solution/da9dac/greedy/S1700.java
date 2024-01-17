package algorithm.solution.da9dac.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.greedy.P1700;

public class S1700 implements P1700 {
	// https://da9dac.tistory.com/288

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] history = new int[k + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= k; i++) {
			history[i] = Integer.parseInt(st.nextToken());
		}

		int tab = n;
		int[] arr = new int[n];
		boolean[] isUsed = new boolean[k + 1];
		int count = 0;

		for (int i = 1; i <= k; i++) {
			int target = history[i];
			int idx = 0;
			int late = 0;

			if (isUsed[target]) continue;
			if (tab > 0) {
				tab--;
				for (int j = 0; j < n; j++) {
					if (arr[j] == 0) {
						arr[j] = target;
						break;
					}
				}
				isUsed[target] = true;
				continue;
			}

			count++;

			for (int j = 0; j < n; j++) {
				int use = arr[j];
				int x = 0;

				for (int l = i + 1; l <= k; l++) {
					if (history[l] == use) {
						x = l;
						break;
					}
				}

				if (x == 0) {
					idx = j;
					break;
				}

				if (x > late) {
					late = x;
					idx = j;
				}
			}

			tab--;
			isUsed[arr[idx]] = false;
			isUsed[target] = true;
			arr[idx] = target;
		}

		System.out.println(count);
	}
}
