package algorithm.solution.da9dac.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.queue.P10845;

public class S10845 implements P10845 {
	// https://da9dac.tistory.com/174

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new Queue<>(n);

		for (int i = 0; i < n; i++) {
			String[] command = br.readLine().split(" ");

			switch (command[0]) {
				case "push": {
					queue.push(Integer.parseInt(command[1]));
					break;
				}
				case "pop": {
					sb.append(queue.pop()).append("\n");
					break;
				}
				case "size": {
					sb.append(queue.size()).append("\n");
					break;
				}
				case "empty": {
					sb.append(queue.empty()).append("\n");
					break;
				}
				case "front": {
					sb.append(queue.front()).append("\n");
					break;
				}
				case "back": {
					sb.append(queue.back()).append("\n");
					break;
				}
			}
		}

		System.out.println(sb);
	}

	private static class Queue<T> {
		private T[] q;
		private int front = 0;
		private int back = 0;

		public Queue(int size) {
			this.q = (T[]) new Object[size];
		}

		public void push(T x) {
			q[back++] = x;
		}

		public Object pop() {
			return empty() == 0 ? q[front++] : -1;
		}

		public int size() {
			return back - front;
		}

		public int empty() {
			return size() == 0 ? 1 : 0;
		}

		public Object front() {
			return empty() == 0 ? q[front] : -1;
		}

		public Object back() {
			return empty() == 0 ? q[back - 1] : -1;
		}
	}
}
