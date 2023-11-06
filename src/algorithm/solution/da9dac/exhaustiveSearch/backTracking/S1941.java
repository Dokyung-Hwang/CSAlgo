package algorithm.solution.da9dac.exhaustiveSearch.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

import algorithm.problem.baekjoon.backTracking.P1941;

public class S1941 implements P1941 {

	/*
		S는 이다'솜'파	Y는 임도'연'파

		25명에서 7명을 뽑아야 함
		7명의 자리는 가로나 세로로 반드시 인접해 있어야 함
		7명에서 4명 이상은 이다솜파(S)여야 함 (S >= 4)
	 */

	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	private static char[][] seats = new char[5][5];
	private static boolean[][] isVisited = new boolean[5][5];
	private static Queue<Pair> queue = new ArrayDeque<>();
	private static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			seats[i] = br.readLine().toCharArray();
		}

		System.out.println(count);
	}

	private static void combination(int size) {
		if (size == 7) {
			count++;
			return;
		}

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			for (int xy = 0; xy < 4; xy++) {
				int x = cur.x + dx[xy];
				int y = cur.y + dy[xy];
			}
		}
	}

	private static class Pair {
		int x;
		int y;

		public Pair(int x) {
			this.x = x;
		}
	}
}
