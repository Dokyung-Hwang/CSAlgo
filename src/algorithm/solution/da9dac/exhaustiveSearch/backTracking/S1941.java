package algorithm.solution.da9dac.exhaustiveSearch.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

import algorithm.problem.baekjoon.backTracking.P1941;

public class S1941 implements P1941 {
	// https://da9dac.tistory.com/236

	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	private static char[][] seats = new char[5][5];
	private static Pair[] seven = new Pair[7];
	private static Queue<Pair> queue = new ArrayDeque<>();
	private static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			seats[i] = br.readLine().toCharArray();
		}

		combination(0, 0, 0);

		System.out.println(count);
	}

	private static void combination(int size, int start, int yeon) {
		if (yeon > 3) return;

		if (size == 7) {
			if (isLinked()) {
				count++;
			}
			return;
		}

		for (int i = start; i < 25; i++) {
			Pair pair = new Pair(i / 5, i % 5);
			seven[size] = pair;
			if (seats[pair.x][pair.y] == 'Y') {
				combination(size + 1, i + 1, yeon + 1);
			} else {
				combination(size + 1, i + 1, yeon);
			}
		}
	}

	private static boolean isLinked() {
		int[][] newSeats = new int[5][5];
		boolean[][] isVisited = new boolean[5][5];
		int s = 1;

		for (Pair pair : seven) {
			newSeats[pair.x][pair.y] = 1;
		}

		Pair pair = seven[0];
		queue.offer(pair);
		isVisited[pair.x][pair.y] = true;

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			for (int xy = 0; xy < 4; xy++) {
				int x = cur.x + dx[xy];
				int y = cur.y + dy[xy];

				if (x < 0 || x > 4 || y < 0 || y > 4) continue;
				if (isVisited[x][y] || newSeats[x][y] == 0) continue;

				s++;
				queue.offer(new Pair(x, y));
				isVisited[x][y] = true;
			}

		}

		return s == 7;
	}

	private static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
