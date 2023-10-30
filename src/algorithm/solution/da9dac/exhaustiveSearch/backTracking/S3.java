package algorithm.solution.da9dac.exhaustiveSearch.backTracking;

import java.util.HashSet;

import algorithm.problem.programmers.bruteForce.P3;

public class S3 implements P3 {

	private static String[] arr;
	private static StringBuilder sb;
	private static int n;
	private static int count;
	private static boolean[] isUsed;
	private static String[] results;
	private static HashSet<Integer> set;

	public static void main(String[] args) {
		System.out.println(solution("17"));
		System.out.println(solution("011"));
	}

	private static int solution(String numbers) {
		arr = numbers.split("");
		set = new HashSet<>();
		count = 0;

		for (int i = 1; i <= arr.length; i++) {
			n = i;
			results = new String[i];
			isUsed = new boolean[arr.length];
			createPermutation(0);
		}

		for (int s : set) {
			if (checkPrime(s)) {
				count++;
			}
		}

		return count;
	}

	private static void createPermutation(int size) {
		if (size == n) {
			sb = new StringBuilder();

			for (String result : results) {
				sb.append(result);
			}

			set.add(Integer.parseInt(sb.toString()));

			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!isUsed[i]) {
				results[size] = arr[i];
				isUsed[i] = true;
				createPermutation(size + 1);
				isUsed[i] = false;
			}
		}
	}

	private static boolean checkPrime(int num) {
		if (num <= 1) {
			return false;
		}

		for(int i=2 ; i*i<=num; i++) {
			if(num%i ==0) {
				return false;
			}
		}
		return true;
	}
}
