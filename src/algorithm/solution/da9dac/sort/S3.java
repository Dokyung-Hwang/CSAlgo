package algorithm.solution.da9dac.sort;

import java.util.Arrays;

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
		Arrays.sort(citations);

		int max = 0;

		for (int i =  citations[citations.length - 1]; i >= 1; i--) {
			if (citations.length - i < i) {
				int num = 0;
				for (int citation : citations) {
					if (citation >= i) {
						num++;
						if (num == i) {
							return i;
						}
					}
				}
			}
		}

		return max;
	}
}
