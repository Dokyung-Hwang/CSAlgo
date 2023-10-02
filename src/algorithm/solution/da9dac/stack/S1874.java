package algorithm.solution.da9dac.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import algorithm.problem.stack.P1874;

public class S1874 implements P1874 {
	// https://da9dac.tistory.com/170

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int index = 0;

		Stack<Integer> stack = new Stack<>();

		int[] sequence = new int[n];
		int[] result = new int[n];

		for (int i = 0; i < n; i++) {
			sequence[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= n; i++) {
			stack.push(i);
			sb.append("+\n");

			while (!stack.isEmpty() && stack.peek() == sequence[index]) {
				result[index++] = stack.pop();
				sb.append("-\n");
			}
		}

		if (result[n - 1] == 0) {
			System.out.println("NO");
		} else {
			System.out.println(sb);
		}
	}
}
