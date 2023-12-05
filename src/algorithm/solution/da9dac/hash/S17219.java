package algorithm.solution.da9dac.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.hash.P17219;

public class S17219 implements P17219 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<String, String> map = new HashMap<>();

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}

		StringBuilder sb = new StringBuilder();

		while (m-- > 0) {
			sb.append(map.get(br.readLine())).append("\n");
		}

		System.out.println(sb);
	}
}
