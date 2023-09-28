package algorithm.solution.da9dac.array;

import java.util.Scanner;

import algorithm.problem.array.P10808;

public class S10808 implements P10808 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String input = s.next();

		byte[] answer = new byte[26];

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			answer[c - 97]++;
		}

		for (byte a : answer) {
			System.out.print(a + " ");
		}
	}
}
