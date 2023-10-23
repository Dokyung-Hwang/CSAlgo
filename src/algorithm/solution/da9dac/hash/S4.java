package algorithm.solution.da9dac.hash;

import java.util.HashMap;
import java.util.Iterator;

import algorithm.problem.programmers.hash.P4;

public class S4 implements P4 {

	public static void main(String[] args) {
		System.out.println(
			solution(
				new String[][]{
					{"yellow_hat", "headgear"},
					{"blue_sunglasses", "eyewear"},
					{"green_turban", "headgear"}
				}
			)
		);

		System.out.println(
			solution(
				new String[][]{
					{"crow_mask", "face"},
					{"blue_sunglasses", "face"},
					{"smoky_makeup", "face"}
				}
			)
		);
	}

	private static int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<>();

		for (String[] cloth : clothes) {
			String category = cloth[1];
			map.put(category, map.getOrDefault(category, 0) + 1);
		}

		Iterator<Integer> it = map.values().iterator();
		int answer = 1;

		while(it.hasNext())
			answer *= it.next() + 1;

		return answer - 1;
	}
}
