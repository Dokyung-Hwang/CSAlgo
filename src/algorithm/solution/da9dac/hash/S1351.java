package algorithm.solution.da9dac.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.hash.P1351;

public class S1351 implements P1351 {

	private static long n;
	private static int p;
	private static int q;
	private static Map<Long, Long> sequence = new HashMap<>();

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());

		n = Long.parseLong(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		System.out.println(createSequence(n));
	}

	private static long createSequence(long num) {
		if (num == 0) return 1L;
		if (sequence.containsKey(num)) return sequence.get(num);

		sequence.put(num, createSequence(num/p) + createSequence(num/q));
		return sequence.get(num);
	}
}
