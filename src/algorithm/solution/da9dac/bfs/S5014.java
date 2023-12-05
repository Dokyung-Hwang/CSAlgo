package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.bfs.P5014;

public class S5014 implements P5014 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken()) - 1;
		int g = Integer.parseInt(st.nextToken()) - 1;
		int u = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		boolean[] isVisited = new boolean[f];

		Queue<Gangho> q = new LinkedList<>();
		q.offer(new Gangho(s, 0, 0));
		isVisited[s] = true;
		isVisited[s] = true;

		int min = Integer.MAX_VALUE;

		while(!q.isEmpty()) {
			Gangho cur = q.poll();

			if (cur.x == g) {
				min = Math.min(min, cur.moveUp + cur.moveDown);
				continue;
			}

			int up = cur.x + u;
			int down = cur.x - d;

			if (up < f && !isVisited[up]) {
				isVisited[up] = true;
				q.offer(new Gangho(up, cur.moveUp + 1, cur.moveDown));
			}
			if (down >= 0 && !isVisited[down]) {
				isVisited[down] = true;
				q.offer(new Gangho(down, cur.moveUp, cur.moveDown + 1));
			}
		}

		if (min == Integer.MAX_VALUE) {
			System.out.println("use the stairs");
		} else {
			System.out.println(min);
		}
	}

	public static class Gangho {
		int x;
		int moveUp;
		int moveDown;

		public Gangho(int x, int moveUp, int moveDown) {
			this.x = x;
			this.moveUp = moveUp;
			this.moveDown = moveDown;
		}
	}
}
