package algorithm.solution.da9dac.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.twoPointer.P2003;

public class S2003 implements P2003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());


		int end = 1;
		int sum = arr[0];
		int count = 0;

		for (int start = 0; start < n; start++) {
			while (sum < m && end < n) sum += arr[end++];

			if (sum == m) count++;

			sum -= arr[start];
		}

		System.out.println(count);
	}
}
