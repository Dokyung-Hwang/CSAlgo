package algorithm.solution.da9dac.stack.advance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import algorithm.problem.stack.advance.P2504;

public class S2504 implements P2504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] input = br.readLine().toCharArray();

		Stack<Character> stack = new Stack<>();

		int sum = 0;
		int num = 1; // 4

		for (int i = 0; i < input.length; i++) {
			char c = input[i];

			if (c == '(') {
				stack.push(c);
				num *= 2;
			} else if (c == '[') {
				stack.push(c);
				num *= 3;
			} else if (c == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					System.out.println(0);
					return;
				}

				stack.pop();

				if (input[i - 1] == '(') {
					sum += num;
				}
				num /= 2;
			} else {
				if (stack.isEmpty() || stack.peek() != '[') {
					System.out.println(0);
					return;
				}

				stack.pop();

				if (input[i - 1] == '[') {
					sum += num;
				}
				num /= 3;
			}
		}

		if (stack.isEmpty()) {
			System.out.println(sum);
		} else {
			System.out.println(0);
		}
	}
}
