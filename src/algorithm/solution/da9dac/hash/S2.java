package algorithm.solution.da9dac.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import algorithm.problem.programmers.hash.P2;

public class S2 implements P2 {

	public static void main(String[] args) {
		String[] participant1 = {"leo", "kiki", "eden"};
		String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
		String[] completion1 = {"eden", "kiki"};
		String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
		String[] completion3 = {"stanko", "ana", "mislav"};
		System.out.println(solution(participant1, completion1));
		System.out.println(solution(participant2, completion2));
		System.out.println(solution(participant3, completion3));
	}

	private static String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<>();

		for (String p : participant) {
			map.merge(p, 1, Integer::sum);
		}

		for (String c : completion) {
			if (map.get(c) == 1) {
				map.remove(c);
			} else {
				map.merge(c, -1, Integer::sum);
			}
		}

		Set<String> keySet = map.keySet();

		return (String)keySet.toArray()[0];
	}
}
