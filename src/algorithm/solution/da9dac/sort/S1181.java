package algorithm.solution.da9dac.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import algorithm.problem.baekjoon.sort.P1181;

public class S1181 implements P1181 {
	// https://da9dac.tistory.com/252

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Set<String> set = new TreeSet<>(Comparator.comparingInt(String::length).thenComparing(o -> o));

		for (int i = 0; i < n; i++) set.add(br.readLine());

		for (String s : set) sb.append(s).append("\n");

		System.out.println(sb);
	}
}
