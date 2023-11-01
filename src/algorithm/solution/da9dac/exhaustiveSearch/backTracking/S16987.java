package algorithm.solution.da9dac.exhaustiveSearch.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.backTracking.P16987;

public class S16987 implements P16987 {

	private static int n;
	private static int max = 0;
	private static Egg[] eggs;
	private static boolean[] isUsed;
	private static boolean[] isBroken;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		eggs = new Egg[n];
		isUsed = new boolean[n];
		isBroken = new boolean[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < n; i++) {
			isUsed[i] = true;
			eggToEgg(0, i); // 1. 달걀을 하나 집는다
			isUsed[i] = false;
		}

		System.out.println(max);
	}

	private static void eggToEgg(int broken, int now) { // 현재 손에 들고 있는 계란
		if (broken == n) {
			return;
		}

		if (now >= eggs.length) {
			return;
		}

		Egg egg = eggs[now];

		for (int i = 0; i < n; i++) {
			if (!isBroken[i] && !isUsed[i]){
				Egg otherEgg = eggs[i];
				isUsed[i] = true; // 부딪힐 달걀을 집는다.

				egg.durability = egg.durability - otherEgg.weight; // 2. 집은 달걀로 다음 달걀을 친다
				otherEgg.durability = otherEgg.durability - egg.durability; // 3. 내구도 계산

				if (egg.durability < 1) isBroken[now] = true; // 4. 달걀이 깨진지 확인
				if (egg.durability < 1) isBroken[i] = true;

				if (isBroken[now]) {
					// 깨졌다면 다음 달걀로 바꿔야하는데
					// 만약 서로 부딪힌 두 달걀이 다 깨졌다면?
					eggToEgg(broken + 1, i);
				} else { // 깨지지 않았다면
					eggToEgg(broken + 1, now);
				}
			}
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
