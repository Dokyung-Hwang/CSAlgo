package algorithm.solution.da9dac.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.greedy.P2457;

public class S2457 implements P2457 {
	// https://da9dac.tistory.com/284

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] flowers = new int[n][4];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			flowers[i][0] = Integer.parseInt(st.nextToken());
			flowers[i][1] = Integer.parseInt(st.nextToken());
			flowers[i][2] = Integer.parseInt(st.nextToken());
			flowers[i][3] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(flowers, (o1, o2) -> {
			if (o1[0] != o2[0]) {
				return o1[0] - o2[0];
			} else {
				if (o1[1] != o2[1]) {
					return o1[1] - o2[1];
				} else {
					if (o1[2] != o2[2]) {
						return o1[2] - o2[2];
					} else {
						return o1[3] - o2[3];
					}
				}
			}
		});

		int min = 0;
		int psm = 0;
		int psd = 0;
		int pem = 0;
		int ped = 0;

		for (int i = 0; i < n; i++) {
			int sm = flowers[i][0];
			int sd = flowers[i][1];
			int em = flowers[i][2];
			int ed = flowers[i][3];

			if (sm < 3 || (sm == 3 && sd == 1)) {
				if (em < pem || (em == pem && ed <= ped)) continue;
				min = 1;
				psm = sm;
				psd = sd;
				pem = em;
				ped = ed;
				if (end(pem, min))
					return;
				continue;
			}

			if (min == 0) continue;

			if (sm < psm || sm == psm && sd <= psd) {
				if (em < pem || (em == pem && ed <= ped)) continue;
				pem = em;
				ped = ed;
				if (end(pem, min))
					return;
				continue;
			}

			if (sm < pem || (sm == pem && sd <= ped)) {
				min++;
				psm = pem;
				psd = ped;
				pem = em;
				ped = ed;
			}

			if (end(pem, min))
				return;
		}

		System.out.println(0);
	}

	private static boolean end(int pem, int min) {
		if (pem > 11) {
			System.out.println(min);
			return true;
		}
		return false;
	}
}
