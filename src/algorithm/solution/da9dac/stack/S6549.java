package algorithm.solution.da9dac.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.stack.P6549;

public class S6549 implements P6549 {
	// https://da9dac.tistory.com/255

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());

			if (n == 0) break;

			int[] arr = new int[n + 2];
			for (int i = 1; i <= n; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			Stack<Integer> histograms = new Stack<>();
			histograms.push(0);

			long max = 0;

			for (int i = 1; i <= n + 1; i++) {
				while (!histograms.isEmpty()) {
					int prev = arr[histograms.peek()];
					if (prev <= arr[i])
						break;
					histograms.pop();
					max = Math.max(max, (long)prev * (i - histograms.peek() - 1));
				}
				histograms.push(i);
			}

			sb.append(max).append("\n");
		}

		System.out.println(sb);
	}
}