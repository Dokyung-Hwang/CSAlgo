package algorithm.solution.da9dac.sort;

import algorithm.problem.programmers.sort.P3;

public class S3 implements P3 {

	public static void main(String[] args) {
		System.out.println(
			solution(
				new int[] {3, 0, 6, 1, 5}
			)
		);
	}

	private static int solution(int[] citations) {

		int[] count = new int[10001];

		int max = 0;

		for (int citation : citations) {
			count[citation]++;
		}

		for (int i = 1; i < count.length; i++) {
			if (count[i] >= i && citations.length - i < i) {
				max = i;
			}
		}

		return max;
	}
}
