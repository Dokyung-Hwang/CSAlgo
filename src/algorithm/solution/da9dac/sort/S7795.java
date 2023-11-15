package algorithm.solution.da9dac.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.sort.P7795;

public class S7795 implements P7795 {
	// https://da9dac.tistory.com/254

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			Integer[] a = new Integer[n];
			Integer[] b = new Integer[m];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				a[j] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				b[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(a);
			Arrays.sort(b);

			int count = 0;
			int max = a[n - 1];

			for (int j = 0; j < m; j++) {
				int num = b[j];
				if (num >= max) break;
				for (int k = 0; k < n; k++) {
					if (num >= a[k]) continue;
					count += n - k;
					break;
				}
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}
}
