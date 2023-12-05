package algorithm.solution.da9dac.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algorithm.problem.baekjoon.sort.P11652;

public class S11652 implements P11652 {
	// https://da9dac.tistory.com/250

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Map<Long, Integer> cards = new HashMap<>();

		for (int i = 0; i < n; i++) {
			long card = Long.parseLong(br.readLine());

			cards.put(card, cards.getOrDefault(card, 0) + 1);
		}

		List<Map.Entry<Long, Integer>> entries = new ArrayList<>(cards.entrySet());
		entries.sort(
			(o1, o2) -> {
				int ov = o1.getValue();
				int tv = o2.getValue();

				long ok = o1.getKey();
				long tk = o2.getKey();

				if (ov < tv) {
					return 1;
				} else if (ov > tv) {
					return -1;
				} else {
					if (ok < tk) {
						return -1;
					} else if (ok > tk) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		);

		System.out.println(entries.get(0).getKey());
	}
}
