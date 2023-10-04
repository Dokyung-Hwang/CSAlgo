package algorithm.solution.da9dac.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

import algorithm.problem.deque.P5430;

public class S5430 implements P5430 {
	// https://da9dac.tistory.com/179

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String[] p = br.readLine().split("");
			int n = Integer.parseInt(br.readLine());
			String arrInput = br.readLine();

			String[] arr = arrInput.substring(1, arrInput.length() - 1).split(",");

			ArrayDeque<Integer> deque = new ArrayDeque<>();

			boolean reversed = false;

			for (int j = 0; j < arr.length; j++) {
				if (!arr[j].isEmpty()) {
					deque.offer(Integer.parseInt(arr[j]));
				}
			}

			out:
			for (int j = 0; j < p.length; j++) {
				switch (p[j]) {
					case "R": {
						reversed = !reversed;
						break;
					}
					case "D": {
						if (deque.isEmpty()) {
							sb.append("error").append("\n");
							break out;
						}

						if (reversed) {
							deque.pollLast();
						} else {
							deque.poll();
						}
						break;
					}
				}

				if (j == p.length - 1) {
					sb.append("[");

					while (!deque.isEmpty()) {
						sb.append(reversed ? deque.pollLast() : deque.poll());

						if (!deque.isEmpty()) {
							sb.append(",");
						}
					}

					sb.append("]").append("\n");
				}
			}
		}

		System.out.println(sb);
	}
}
