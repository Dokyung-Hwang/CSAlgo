package algorithm.solution.da9dac.exhaustiveSearch.backTracking;

import java.util.HashSet;

import algorithm.problem.programmers.bruteForce.P3;

public class S3 implements P3 {

	private String[] arr;
	private StringBuilder sb;
	private int n;
	private int count;
	private boolean[] isUsed;
	private String[] results;
	private HashSet<Integer> set;

	public int solution(String numbers) {
		arr = numbers.split("");
		isUsed = new boolean[arr.length];
		set = new HashSet<>();
		count = 0;

		for (int i = 1; i <= arr.length; i++) {
			n = i;
			results = new String[i];
			createPermutation(0);
		}

		for (int s : set) {
			if (checkPrime(s)) {
				count++;
			}
		}

		return count;
	}

	void createPermutation(int size) {
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

	boolean checkPrime(int num) {
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
