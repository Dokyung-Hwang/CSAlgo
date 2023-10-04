package algorithm.solution.da9dac.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

import algorithm.problem.stack.P10773;

public class S10773 implements P10773 {
	// https://da9dac.tistory.com/manage/posts/

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int k = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < k; i++) {
			int number = Integer.parseInt(br.readLine());

			if (number == 0) {
				stack.pop();
			} else {
				stack.push(number);
			}
		}

		int sum = 0;

		for (int s : stack) {
			sum += s;
		}

		bw.write(sum + "");
		bw.flush();
	}
}
