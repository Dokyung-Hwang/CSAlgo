package algorithm.solution.da9dac.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

import algorithm.problem.stack.P10828;

public class S10828 implements P10828 {
	// https://da9dac.tistory.com/168

	private static class Stack {
		Vector<Integer> vector = new Vector<>();

		private void push(Integer x) {
			vector.add(x);
		}

		private int pop() {
			try {
				return vector.remove(vector.size() - 1);
			} catch (Exception e) {
				return -1;
			}
		}

		private int size() {
			return vector.size();
		}

		private int empty() {
			return size() == 0 ? 1 : 0;
		}

		private int top() {
			try {
				return vector.get(size() - 1);
			} catch (Exception e) {
				return -1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Stack stack = new Stack();

		for (int i = 0; i < n; i++) {
			String[] command = br.readLine().split(" ");

			switch (command[0]) {
				case "push": {
					stack.push(Integer.parseInt(command[1]));
					break;
				}
				case "pop": {
					sb.append(stack.pop()).append("\n");
					break;
				}
				case "size": {
					sb.append(stack.size()).append("\n");
					break;
				}
				case "empty": {
					sb.append(stack.empty()).append("\n");
					break;
				}
				case "top": {
					sb.append(stack.top()).append("\n");
					break;
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
	}
}
