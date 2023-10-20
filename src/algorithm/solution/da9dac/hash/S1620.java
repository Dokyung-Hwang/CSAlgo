package algorithm.solution.da9dac.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import algorithm.problem.baejoon.hash.P1620;

public class S1620 implements P1620 {

	private static String name;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] nm = br.readLine().split(" ");

		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		HashMap<String, Integer> monsterNames = new HashMap<>();
		HashMap<Integer, String> monsterNumbers = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			name = br.readLine();
			monsterNames.put(name, i);
			monsterNumbers.put(i, name);
		}

		for (int i = 0; i < m; i++) {
			String quiz = br.readLine();

			if (Character.isDigit(quiz.charAt(0))) {
				sb.append(monsterNumbers.get(Integer.parseInt(quiz))).append("\n");
			} else {
				sb.append(monsterNames.get(quiz)).append("\n");
			}
		}

		System.out.println(sb);
	}
}
