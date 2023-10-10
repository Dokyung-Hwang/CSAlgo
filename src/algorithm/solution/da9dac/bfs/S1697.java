package algorithm.solution.da9dac.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import algorithm.problem.bfs.P1697;

public class S1697 implements P1697 {
	// https://da9dac.tistory.com/192

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] road = new int[200002];

		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(n);
		road[n] = 1;

		if (n == k && n == 0) {
			System.out.println(0);
			return;
		}

		while (road[k] == 0) {
			int cur = queue.poll();
			int x = 0;

			for (int i = 0; i < 3; i++) {
				switch (i) {
					case 0: {
						x = cur - 1;
						break;
					}
					case 1: {
						x = cur + 1;
						break;
					}
					case 2: {
						x = cur * 2;
						break;
					}
				}

				if (x < 0 || x >= 200002) continue;
				if (road[x] > 0) continue;

				queue.offer(x);
				road[x] = road[cur] + 1;
			}
		}

		System.out.println(road[k] - 1);
	}
}
