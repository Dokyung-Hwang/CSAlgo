package algorithm.solution.da9dac.array;

import java.util.Scanner;

import algorithm.problem.array.P2577;

public class S2577 implements P2577 {
	// https://da9dac.tistory.com/162

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();

		String result = String.valueOf(a * b * c);

		int[] counts = new int[10];

		for (int i = 0; i < result.length(); i++) {
			int number = result.charAt(i) - '0';

			counts[number]++;
		}

		for (int count : counts) {
			System.out.println(count);
		}
	}
}