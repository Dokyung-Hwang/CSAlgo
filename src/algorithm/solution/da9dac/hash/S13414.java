package algorithm.solution.da9dac.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

import algorithm.problem.baekjoon.hash.P13414;

public class S13414 extends P13414 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int count = 1;
		Set<String> set = new LinkedHashSet<>();

		while (l-- > 0) {
			String num = br.readLine();
			set.remove(num);
			set.add(num);
		}

		for (String s : set) {
			if (count > k) break;
			sb.append(s).append("\n");
			count++;
		}

		System.out.println(sb);
	}
}
