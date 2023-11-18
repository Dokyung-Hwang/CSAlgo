package algorithm.solution.da9dac.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import algorithm.problem.baekjoon.sort.P2910;

public class S2910 implements P2910 {
	// https://da9dac.tistory.com/253

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		Map<Integer, Integer> sequence = new LinkedHashMap<>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			int key = Integer.parseInt(st.nextToken());
			sequence.put(key, sequence.getOrDefault(key, 0) + 1);
		}

		List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(sequence.entrySet()).stream()
			.sorted((o1, o2) -> {
				int ov = o1.getValue();
				int tv = o2.getValue();

				if (ov == tv) {
					return 0;
				} else if (ov > tv) {
					return -1;
				} else {
					return 1;
				}
			}).collect(Collectors.toList());

		for (Map.Entry<Integer, Integer> entry : entries) {
			int target = entry.getKey();
			int end = entry.getValue();

			for (int i = 0; i < end; i++) {
				sb.append(target).append(" ");
			}
		}

		System.out.println(sb);
	}
}
