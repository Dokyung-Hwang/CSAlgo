package algorithm.solution.da9dac.exhaustiveSearch.bruteForce;

import algorithm.problem.programmers.bruteForce.P1;

public class S1 implements P1 {

	public static void main(String[] args) {
		System.out.println(solution(
			new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}
		));
		System.out.println(solution(
			new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}
		));
		System.out.println(solution(
			new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}
		));
	}

	private static int solution(int[][] sizes) {
		int max1 = 0;
		int max2 = 0;

		for (int i = 0; i < sizes.length; i++) {
			int left = sizes[i][0];
			int right = sizes[i][1];

			if (left > right) {
				sizes[i][0] = right;
				sizes[i][1] = left;
			}

			max1 = Math.max(sizes[i][1], max1);
			max2 = Math.max(sizes[i][0], max2);
		}

		return max1 * max2;
	}
}
