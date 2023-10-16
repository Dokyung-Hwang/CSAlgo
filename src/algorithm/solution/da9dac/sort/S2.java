package algorithm.solution.da9dac.sort;

import java.util.Arrays;

import algorithm.problem.programmers.sort.P2;

public class S2 implements P2 {

	public static void main(String[] args) {
		System.out.println(
			solution(
				new int[] {0, 0, 0, 0}
			)
		);
	}

	private static String solution(int[] numbers) {
		StringBuilder sb = new StringBuilder();

		String[] arr = new String[numbers.length];
		int zeroCount = 0;

		for (int i = 0; i < arr.length; i++) {
			if (numbers[i] == 0) {
				zeroCount++;
			}
			arr[i] = String.valueOf(numbers[i]);
		}

		if (zeroCount == arr.length) {
			return "0";
		}

		Arrays.sort(arr, (num1, num2) -> (num2 + num1).compareTo(num1 + num2));

		for (String s : arr) {
			sb.append(s);
		}

		return sb.toString();
	}
}
