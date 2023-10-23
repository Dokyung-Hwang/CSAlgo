package algorithm.solution.da9dac.hash;

import java.util.HashSet;

import algorithm.problem.programmers.hash.P1;

public class S1 implements P1 {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{3, 3, 3, 2, 2, 2}));
	}

	private static int solution(int[] nums) {
		HashSet<Integer> monsters = new HashSet<>();

		for (int num : nums) {
			monsters.add(num);
		}

		int n = nums.length / 2;

		if (n > monsters.size()) {
			return monsters.size();
		} else {
			return n;
		}

	}
}
