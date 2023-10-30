package algorithm.solution.da9dac;

import algorithm.solution.da9dac.exhaustiveSearch.backTracking.S3;

public class ProgrammersRun {

	public static void main(String[] args) {
		runS3(); // 완전탐색 : 소수 찾기
	}

	private static void runS3() {
		S3 solution = new S3();
		System.out.println(solution.solution("17"));
		System.out.println(solution.solution("011"));
	}
}
