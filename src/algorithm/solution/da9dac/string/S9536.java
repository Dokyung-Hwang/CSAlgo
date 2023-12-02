package algorithm.solution.da9dac.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.string.P9536;

public class S9536 implements P9536 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String[] says = br.readLine().split(" ");

			while (true) {
				String animals = br.readLine();
				if (animals.equals("what does the fox say?")) break;

				String sound = animals.split(" ")[2];

				for (int i = 0; i < says.length; i++) {
					if (says[i].equals(sound)) says[i] = "";
				}
			}

			for (String say : says) {
				if (!say.isEmpty()) sb.append(say).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
