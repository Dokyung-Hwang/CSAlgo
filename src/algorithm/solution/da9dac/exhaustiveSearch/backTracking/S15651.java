package algorithm.solution.da9dac.exhaustiveSearch.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.backTracking.P15651;

public class S15651 implements P15651 {

	private static StringBuilder sb = new StringBuilder();
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");

		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		arr = new int[m];

		System.out.println(sb);
	}

}
