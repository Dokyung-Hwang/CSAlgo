package algorithm.solution.da9dac.stack.advance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import algorithm.problem.stack.advance.P3986;

public class S3986 implements P3986 {
	// https://da9dac.tistory.com/181

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int result = 0;

		for (int i = 0; i < n; i++) {
			char[] word = br.readLine().toCharArray();

			Stack<Character> stack = new Stack<>();

			for (char c : word) {
				if (stack.isEmpty()) {
					stack.push(c);
				} else {
					char top = stack.peek();
					if (top == c){
						stack.pop();
					} else {
						stack.push(c);
					}
				}
			}

			if (stack.isEmpty()) {
				result++;
			}
		}

		System.out.println(result);
	}
}
