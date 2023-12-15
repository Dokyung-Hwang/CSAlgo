package algorithm.solution.da9dac.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.twoPointer.P1806;

public class S1806 implements P1806 {
	// https://da9dac.tistory.com/263

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];

		int x = 0;

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			x += num;
		}

		if (x < s) {
			System.out.println(0);
			return;
		}

		int end = 1;
		int count = 1;
		int sum = arr[0];
		int min = Integer.MAX_VALUE;


		for (int start = 0; start < n; start++) {
			while (sum < s && end > start && end < n){
				count++;
				sum += arr[end++];
			}

			if (sum >= s) {
				min = Math.min(min, count);
			}

			count--;
			sum -= arr[start];
		}

		System.out.println(min);
	}
}
