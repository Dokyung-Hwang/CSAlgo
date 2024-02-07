package algorithm.solution.da9dac.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

import algorithm.problem.baekjoon.priorityQueue.P1655;

public class S1655 implements P1655 {
	// https://da9dac.tistory.com/294

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> right = new PriorityQueue<>();
		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());

		int center = Integer.parseInt(br.readLine());
		sb.append(center).append("\n");

		for (int i = 2; i <= n; i++) {
			int x = Integer.parseInt(br.readLine());

			if (i % 2 == 0) {
				if (center > x) {
					left.offer(x);
					right.offer(center);
					center = left.poll();
				} else {
					right.offer(x);
				}
			} else {
				if (center <= x) {
					right.offer(x);
					left.offer(center);
					center = right.poll();
				} else {
					left.offer(x);
				}
			}

			sb.append(center).append("\n");
		}

		System.out.println(sb);
	}
}
