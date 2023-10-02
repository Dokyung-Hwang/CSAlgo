package algorithm.solution.da9dac.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import algorithm.problem.stack.P2493;

public class S2493 implements P2493 {
	// https://da9dac.tistory.com/172

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		Stack<Tower> stack = new Stack<>();

		for (int i = 1; i <= n; i++) {
			int current = Integer.parseInt(st.nextToken());

			if (stack.isEmpty()) {
				stack.push(new Tower(i, current));
				sb.append("0 ");
			} else {
				while (true) {
					if (stack.isEmpty()) {
						stack.push(new Tower(i, current));
						sb.append("0 ");
						break;
					}

					Tower tower = stack.peek();

					if (current < tower.height) {
						stack.push(new Tower(i, current));
						sb.append(tower.number).append(" ");
						break;
					} else {
						stack.pop();
					}
				}
			}
		}

		System.out.println(sb);
	}

	static class Tower {
		int number;
		int height;

		public Tower(int number, int height) {
			this.number = number;
			this.height = height;
		}
	}

}
