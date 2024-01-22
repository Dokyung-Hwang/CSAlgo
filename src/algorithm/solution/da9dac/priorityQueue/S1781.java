package algorithm.solution.da9dac.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.priorityQueue.P1781;

public class S1781 implements P1781 {
	// https://da9dac.tistory.com/295

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		long max = 0;

		PriorityQueue<Exam> sorted = new PriorityQueue<>(
			(o1, o2) -> o1.d != o2.d ? o1.d - o2.d : -(o1.c - o2.c)
		);

		PriorityQueue<Integer> cup = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			sorted.offer(new Exam(st.nextToken(), st.nextToken()));
		}

		while (!sorted.isEmpty()){
			Exam exam = sorted.poll();

			int size = cup.size();

			if (size < exam.d) {
				cup.offer(exam.c);
				max += exam.c;
			}
			else if (size == exam.d && cup.peek() < exam.c) {
				int prev = cup.poll();
				cup.offer(exam.c);
				max += (exam.c - prev);
			}
		}

		System.out.println(max);
	}

	private static class Exam {
		int d;
		int c;

		public Exam(String d, String c) {
			this.d = Integer.parseInt(d);
			this.c = Integer.parseInt(c);
		}
	}
}
