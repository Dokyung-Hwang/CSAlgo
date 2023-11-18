package algorithm.solution.da9dac.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

import algorithm.problem.baekjoon.sort.P1431;

public class S1431 implements P1431 {
	// 문제 풀이 : https://da9dac.tistory.com/249
	// Comparator와 Comparable : https://da9dac.tistory.com/248

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		String[] serials = new String[n];

		for (int i = 0; i < n; i++) {
			serials[i] = br.readLine();
		}

		Arrays.sort(serials, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() != o2.length()) {
					return o1.length() - o2.length();
				} else {
					int sum = sum(o1, o2);
					if (sum != 0) {
						return sum;
					}
					else {
						return o1.compareTo(o2);
					}
				}
			}

			int sum(String o1, String o2) {
				int x = 0;
				int y = 0;

				for (int i = 0; i < o1.length(); i++) {
					char cx = o1.charAt(i);
					char cy = o2.charAt(i);

					if (Character.isDigit(cx)) x += (cx - '0');
					if (Character.isDigit(cy)) y += (cy - '0');
				}

				return x - y;
			}
		});

		for (String s : serials) {
			sb.append(s).append("\n");
		}

		System.out.println(sb);
	}
}
