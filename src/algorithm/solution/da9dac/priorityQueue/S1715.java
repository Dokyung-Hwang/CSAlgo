package algorithm.solution.da9dac.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

import algorithm.problem.baekjoon.priorityQueue.P1715;

public class S1715 implements P1715 {
	// https://da9dac.tistory.com/293

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) pq.offer(Integer.parseInt(br.readLine()));

		while (!pq.isEmpty()) {
			if (sum == 0) sum = pq.poll();
			else {
				sum += pq.poll();
				pq.offer(sum);
				min += sum;
				sum = 0;
			}
		}

		System.out.println(min);
	}
}
