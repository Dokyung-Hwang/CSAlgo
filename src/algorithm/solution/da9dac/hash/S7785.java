package algorithm.solution.da9dac.hash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import algorithm.problem.baekjoon.hash.P7785;

public class S7785 implements P7785 {

	private static String[] log;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		HashSet<String> logs = new HashSet<>();

		for (int i = 0; i < n; i++) {
			log = br.readLine().split(" ");

			if (log[1].equals("leave")) {
				logs.remove(log[0]);
			} else {
				logs.add(log[0]);
			}
		}

		List<String> list = logs.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		for (String s : list) {
			sb.append(s).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
	}
}
