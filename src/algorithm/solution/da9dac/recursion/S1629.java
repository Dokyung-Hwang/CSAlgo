package algorithm.solution.da9dac.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baejoon.recursion.P1629;

public class S1629 implements P1629 {
	// https://da9dac.tistory.com/196

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());

		System.out.println(calculate(a, b, c));
	}

	private static long calculate(long a, long b, long c) {
		if (b == 1) return a % c;
		long result = calculate(a, b/2, c);
		result = (result * result) % c;
		if (b % 2 == 0) {
			return result;
		}
		return (a * result) % c;
	}
}
