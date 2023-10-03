package algorithm.solution.da9dac.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.deque.P10866;

public class S10866 implements P10866 {
	// https://da9dac.tistory.com/176

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Deque<Integer> deque = new Deque<>(n);

		for (int i = 0; i < n; i++) {
			String[] command = br.readLine().split(" ");

			switch (command[0]) {
				case "push_back": {
					deque.pushBack(Integer.parseInt(command[1]));
					break;
				}
				case "push_front": {
					deque.pushFront(Integer.parseInt(command[1]));
					break;
				}
				case "pop_back": {
					sb.append(deque.popBack()).append("\n");
					break;
				}
				case "pop_front": {
					sb.append(deque.popFront()).append("\n");
					break;
				}
				case "back": {
					sb.append(deque.back()).append("\n");
					break;
				}
				case "front": {
					sb.append(deque.front()).append("\n");
					break;
				}
				case "size": {
					sb.append(deque.size()).append("\n");
					break;
				}
				case "empty": {
					sb.append(deque.empty()).append("\n");
					break;
				}
			}
		}

		System.out.println(sb);
	}

	private static class Deque<T> {
		private T[] dq;
		private int front;
		private int back;

		public Deque(int size) {
			this.dq = (T[]) new Object[size * 2 + 1];
			this.front = size / 2;
			this.back = size / 2 + 1;
		}

		public void pushFront(T x) {
			dq[front--] = x;
		}

		public void pushBack(T x) {
			dq[back++] = x;
		}

		public Object popFront() {
			return empty() == 0 ? dq[++front] : -1;
		}

		public Object popBack() {
			return empty() == 0 ? dq[--back] : -1;
		}

		public int size() {
			return back - front - 1;
		}

		public int empty() {
			return size() == 0 ? 1 : 0;
		}

		public Object front() {
			return empty() == 0 ? dq[front + 1] : -1;
		}

		public Object back() {
			return empty() == 0 ? dq[back - 1] : -1;
		}
	}
}
