package algorithm.solution.da9dac.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.greedy.P2170;

public class S2170 implements P2170 {
	// https://da9dac.tistory.com/285

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] xy = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			xy[i][0] = Integer.parseInt(st.nextToken());
			xy[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(xy, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);

		int s = xy[0][0];
		int e = xy[0][1];
		int len = e - s;

		for (int i = 1; i < n; i++) {
			int x = xy[i][0];
			int y = xy[i][1];

			if (y <= e) continue;

			if (x <= e) {
				len += (y - e);
			} else {
				len += y - x;
			}

			e = y;
		}

		System.out.println(len);
	}
}
