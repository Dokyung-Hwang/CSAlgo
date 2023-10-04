package algorithm.solution.da9dac.array;

import java.util.Scanner;

import algorithm.problem.array.P1475;

public class S1475 implements P1475 {
	// https://da9dac.tistory.com/163

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String roomNumber = scanner.nextInt() + "";

		int[] count = new int[10];
		int max = 0;
		int sixAndNine = 0;
		int result = 0;

		for (int i = 0; i < roomNumber.length(); i++) {
			count[roomNumber.charAt(i) - '0']++;
		}

		for (int i = 0; i < count.length; i++) {
			if (i == 6 || i == 9) {
				continue;
			}
			max = Math.max(max, count[i]);
		}

		sixAndNine = count[6] + count[9];

		if (max * 2 < sixAndNine) {
			result = (int) Math.ceil(sixAndNine / 2.0);
		} else {
			result = max;
		}

		System.out.println(result);
	}
}
