package algorithm.solution.da9dac.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.sort.P11651;

public class S11651 implements P11651 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] coordinates = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			coordinates[i][0] = Integer.parseInt(st.nextToken());
			coordinates[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(coordinates, (o1, o2) -> {
			int ax = o1[1];
			int bx = o2[1];

			if (ax - bx == 0) {
				return o1[0] - o2[0];
			} else {
				return ax - bx;
			}
		});

		for (int[] coordinate : coordinates) {
			sb.append(coordinate[0]).append(" ").append(coordinate[1]).append("\n");
		}

		System.out.println(sb);
	}
}
