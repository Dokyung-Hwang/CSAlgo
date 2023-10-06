package algorithm.solution.da9dac.stack.advance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import algorithm.problem.stack.advance.P4949;

public class S4949 implements P4949 {
	// https://da9dac.tistory.com/180

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String input = br.readLine();

			if (input.equals(".")) {
				break;
			}

			Stack<Character> stack =new Stack<>();

			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);

				if (c == '(' || c == '[') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.isEmpty() || stack.peek() == '[') {
						sb.append("no").append("\n");
						break;
					}
					stack.pop();
				} else if (c == ']') {
					if (stack.isEmpty() || stack.peek() == '(') {
						sb.append("no").append("\n");
						break;
					}
					stack.pop();
				} else if (c == '.') {
					if (!stack.isEmpty()) {
						sb.append("no").append("\n");
						break;
					}
					sb.append("yes").append("\n");
				}
			}
		}

		System.out.println(sb);
	}
}
