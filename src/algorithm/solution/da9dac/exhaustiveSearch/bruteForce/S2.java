package algorithm.solution.da9dac.exhaustiveSearch.bruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import algorithm.problem.programmers.bruteForce.P2;

public class S2 implements P2 {

	public static void main(String[] args) {
		System.out.println(
			Arrays.toString(
				solution(new int[] {1, 2, 3, 4, 5})
			)
		);
		System.out.println(
			Arrays.toString(
				solution(new int[] {1, 3, 2, 4, 2})
			)
		);
	}

	private static int[] solution(int[] answers) {
		int[][] stupids = new int[][]{
			new int[]{1, 2, 3, 4, 5},
			new int[]{2, 1, 2, 3, 2, 4, 2, 5},
			new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
		};

		int[] scores = new int[stupids.length];
		int now = 0;

		List<Integer> list = new ArrayList<>();
		int max = -1;

		for (int[] arr : stupids) {
			int score = 0;
			int idx = 0;
			int length = arr.length;

			for (int answer : answers) {
				if (answer == arr[idx++]) {
					score++;
				}

				if (idx == length) {
					idx = 0;
				}
			}

			scores[now] = score;

			if (score > max) {
				max = score;
				list.clear();
				list.add(now + 1);
			} else if (score == max) {
				list.add(now + 1);
			}

			now++;
		}

		int[] result = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}

		return result;
	}
}
