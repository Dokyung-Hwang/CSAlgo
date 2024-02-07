package algorithm.solution.da9dac.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

import algorithm.problem.baekjoon.priorityQueue.P11286;

public class S11286 implements P11286 {
	// https://da9dac.tistory.com/290

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(
			(a, b)-> Math.abs(a) == Math.abs(b) ? (a - b) : (Math.abs(a) - Math.abs(b))
		);

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());

			if (x != 0) pq.offer(x);
			else sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
		}

		System.out.println(sb);
	}
}
