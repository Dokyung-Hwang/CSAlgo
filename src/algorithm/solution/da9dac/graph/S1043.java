package algorithm.solution.da9dac.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.graph.P1043;

public class S1043 implements P1043 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int tr = Integer.parseInt(st.nextToken());
		int[] trs = new int[tr];

		for (int i = 0; i < tr; i++) {
			trs[i] = Integer.parseInt(st.nextToken());
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
		}
	}
}
