package algorithm.solution.da9dac.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import algorithm.problem.baekjoon.recursion.P11729;

public class S11729 implements P11729 {
	// https://da9dac.tistory.com/197

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		bw.write(((int) Math.pow(2, n) - 1) + "\n");

		hanoi(1, 3, n);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void hanoi(int start, int target, int n) {
		if (n == 1) {
			sb.append(start).append(" ").append(target).append("\n");
			return;
		}

		hanoi(start, 6 - start - target, n - 1);

		sb.append(start).append(" ").append(target).append("\n");

		hanoi(6 - start - target, target, n - 1);
	}
}
