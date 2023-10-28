package algorithm.solution.da9dac.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import algorithm.problem.programmers.hash.P5;

public class S5 implements P5 {

	public static void main(String[] args) {
		System.out.println(
			Arrays.toString(
				solution(
					new String[] {"classic", "pop", "classic", "classic", "pop"},
					new int[] {500, 600, 150, 800, 2500}
				)
			)
		);
	}

	private static int[] solution(String[] genres, int[] plays) {
		HashMap<String, Best> record = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			String genre = genres[i];

			Best best = record.getOrDefault(genre, new Best());

			int now = plays[i];
			int one = best.one[1];
			best.view += now;

			if (now > one) {
				int[] tmp = best.one;
				best.one = new int[]{i, now};
				best.two = tmp;
			} else if (now == one) {
				if (i < best.one[0]) {
					int[] tmp = best.one;
					best.one = new int[]{i, now};
					best.two = tmp;
				} else {
					best.two = new int[]{i, now};
				}
			} else if (now > best.two[1]) {
				best.two = new int[]{i, now};
			}

			record.put(genre, best);
		}

		List<Best> entryList = record.entrySet().stream()
			.sorted(Comparator.comparingInt((Entry<String, Best> o) -> o.getValue().view).reversed())
			.map(Entry::getValue)
			.collect(Collectors.toList());

		ArrayList<Integer> results = new ArrayList<>();

		for (Best best : entryList) {
			if (best.one[1] == 0) {
				continue;
			} else {
				results.add(best.one[0]);
			}

			if (best.two[1] != 0) {
				results.add(best.two[0]);
			}
		}

		int[] answer = new int[results.size()];

		for (int i = 0; i < results.size(); i++) {
			answer[i] = results.get(i);
		}

		return answer;
	}

	private static class Best {
		int view = 0;
		int[] one = new int[2];
		int[] two = new int[2];
	}

}
