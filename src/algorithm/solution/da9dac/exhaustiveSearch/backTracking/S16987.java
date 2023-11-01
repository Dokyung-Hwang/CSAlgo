package algorithm.solution.da9dac.exhaustiveSearch.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.backTracking.P16987;

public class S16987 implements P16987 {
	// https://da9dac.tistory.com/223

	private static int n;
	private static int max = 0;
	private static Egg[] eggs;
	private static boolean[] isBroken;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		eggs = new Egg[n];
		isBroken = new boolean[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		eggToEgg(0, 0);

		System.out.println(max);
	}

	private static void eggToEgg(int now, int count) {
		if (now == n) {
			max = Math.max(max, count);
			return;
		}

		if (isBroken[now]) {
			eggToEgg(now + 1, count);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!isBroken[i] && i != now) {
				Egg egg = eggs[now];
				Egg newEgg = eggs[i];

				egg.durability = egg.durability - newEgg.weight;
				newEgg.durability = newEgg.durability - egg.weight;

				if (egg.durability <= 0) {
					isBroken[now] = true;
					count++;
				}
				if (newEgg.durability <= 0) {
					isBroken[i] = true;
					count++;
				}

				eggToEgg(now + 1, count);

				egg.durability = egg.durability + newEgg.weight;
				newEgg.durability = newEgg.durability + egg.weight;

				if (isBroken[now]) count--;
				if (isBroken[i]) count--;

				isBroken[now] = false;
				isBroken[i] = false;
			}

			max = Math.max(count, max);
		}
	}

	private static class Egg {
		int durability;
		int weight;

		public Egg(int durability, int weight) {
			this.durability = durability;
			this.weight = weight;
		}
	}
}
