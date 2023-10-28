package algorithm.solution.da9dac.hash;

import java.util.Arrays;

import algorithm.problem.programmers.hash.P3;

public class S3 implements P3 {

	public static void main(String[] args) {
		System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
		System.out.println(solution(new String[]{"123","456","789"}));
		System.out.println(solution(new String[]{"12","123","1235","567","88"}));
	}

	private static boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);

		for (int i = 0; i < phone_book.length - 1; i++) {
			String now = phone_book[i];
			String next = phone_book[i + 1];
			if (now.length() < next.length() && now.equals(next.substring(0, now.length()))) {
				return false;
			}
		}

		return true;
	}
}
