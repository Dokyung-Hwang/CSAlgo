package algorithm.solution.da9dac.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baejoon.recursion.P1780;

public class S1780 implements P1780 {
	// https://da9dac.tistory.com/202

	private static int[][] arr;
	static int minus = 0, zero = 0, plus = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");

			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(inputs[j]);
			}
		}

		count(0, 0, n);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}

	private static void count(int start, int end, int size) {
		if(equals(start, end, size)) {
			int num = arr[start][end];
			if(num == -1) {
				minus++;
			}
			if(num == 0) {
				zero++;
			}
			if(num == 1) {
				plus++;
			}
			return;
		}

		int newSize = size / 3;
		for (int i = start; i < start+size; i+= newSize) {
			for (int j = end; j < end+size; j += newSize) {
				count(i, j, newSize);
			}
		}
	}

	private static boolean equals(int start, int end, int size) {
		for (int i = start; i < start + size; i++) {
			for (int j = end; j < end + size; j++) {
				if(arr[start][end] != arr[i][j])
					return false;
			}
		}

		return true;
	}
}
