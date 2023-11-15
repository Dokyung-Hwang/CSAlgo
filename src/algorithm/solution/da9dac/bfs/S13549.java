package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.bfs.P13549;

public class S13549 implements P13549 {
	// https://da9dac.tistory.com/246

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		boolean[] isVisited = new boolean[100001];

		Queue<Subin> q = new LinkedList<>();
		q.offer(new Subin(n, 0));

		int min = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			Subin cur = q.poll();

			int x = cur.x;
			int move = cur.move;
			isVisited[x] = true;

			if (x == k) {
				min = Math.min(min, move);
				continue;
			}

			int back = x - 1;
			int front = x + 1;
			int tp = x + x;

			if (tp < 100001 && !isVisited[tp]) q.offer(new Subin(tp, move));
			if (front <= k && !isVisited[front]) q.offer(new Subin(front, move + 1));
			if (back >= 0 && !isVisited[back]) q.offer(new Subin(back, move + 1));
		}

		System.out.println(min);
	}

	private static class Subin {
		int x;
		int move;

		public Subin(int x, int move) {
			this.x = x;
			this.move = move;
		}
	}
}
