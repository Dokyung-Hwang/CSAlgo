package algorithm.solution.da9dac.exhaustiveSearch.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.backTracking.P1941;

public class S1941 implements P1941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] expression = br.readLine().toCharArray();
		boolean isOpen = false;

		for (int i = 0; i < expression.length; i++) {
			char exp = expression[i];
			sb.append(exp);
			if (exp == '-' && !isOpen) {
					isOpen = !isOpen;
					sb.append("(");
			} else if (exp == '-' || (i == expression.length - 1 && isOpen)) {
				isOpen = !isOpen;
				sb.append(")");
			}
		}

		String[] results = sb.toString().split("-");

		// 55 - (50+40)

		System.out.println(sb);
	}
}
