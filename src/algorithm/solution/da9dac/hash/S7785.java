package algorithm.solution.da9dac.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

import algorithm.problem.baekjoon.hash.P7785;

public class S7785 implements P7785 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		TreeSet<String> logs = new TreeSet<>();

		for (int i = 0; i < n; i++) {
			String[] log = br.readLine().split(" ");

			if (log[1].equals("leave")) {
				logs.remove(log[0]);
			} else {
				logs.add(log[0]);
			}
		}

		for (Iterator<String> it = logs.descendingIterator(); it.hasNext(); ) {
			sb.append(it.next()).append("\n");
		}

		System.out.println(sb);
	}
}
