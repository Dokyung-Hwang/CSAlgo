package algorithm.solution.da9dac.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.hash.P9375;

public class S9375 implements P9375 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			Map<String, Integer> clothes = new HashMap<>();

			while (n-- > 0) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String type = st.nextToken();
				clothes.put(type, clothes.getOrDefault(type, 1) + 1);
			}

			sb.append(clothes.values().stream().reduce(1, (a, b) -> a * b) - 1).append("\n");
		}

		System.out.println(sb);
	}
}
