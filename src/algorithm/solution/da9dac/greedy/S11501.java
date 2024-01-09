package algorithm.solution.da9dac.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.greedy.P11501;

public class S11501 implements P11501 {
	// https://da9dac.tistory.com/282

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		int n;
		int[] arr;

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			long profit = 0;
			long max = 0;
			long sum = 0;
			long count = 0;

			for (int i = n - 1; i >= 0; i--) {
				long price = arr[i];

				if (max == 0) {
					max = price;
					continue;
				}

				if (i == 0) {
					if (price <= max) {
						count++;
						sum += price;
					}
					profit += (count * max - sum);
					continue;
				}

				if (max >= price) {
					count++;
					sum += price;
				} else {
					profit += (count * max - sum);
					count = 0;
					sum = 0;
					max = price;
				}
			}

			sb.append(profit).append("\n");
		}

		System.out.println(sb);
	}
}
