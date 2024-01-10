package algorithm.solution.da9dac.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.greedy.P1541;

public class S1541 implements P1541 {
	// https://da9dac.tistory.com/283

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		int sum = 0;
		int len = 0;
		int num;
		char c;
		boolean isMinus = false;

		for (int i = 0; i < input.length(); i++) {
			c = input.charAt(i);

			if (Character.isDigit(c)) len++;

			if (c == '-') {
				isMinus = true;
				continue;
			}

			if (i == input.length() - 1 || !Character.isDigit(input.charAt(i + 1))) {
				num = Integer.parseInt(input.substring(i + 1 - len, i + 1));
				sum = isMinus ? sum - num : sum + num;
				len = 0;
			}
		}

		System.out.println(sum);
	}
}
