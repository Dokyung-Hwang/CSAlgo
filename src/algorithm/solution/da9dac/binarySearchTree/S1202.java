package algorithm.solution.da9dac.binarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import algorithm.problem.baekjoon.binarySearchTree.P1202;

public class S1202 implements P1202 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long max = 0;

		PriorityQueue<Gem> gems = new PriorityQueue<>();
		PriorityQueue<Integer> bags = new PriorityQueue<>();
		PriorityQueue<Integer> values = new PriorityQueue<>(Comparator.reverseOrder());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			gems.offer(new Gem(m, v));
		}

		for (int i = 0; i < k; i++) {
			int c = Integer.parseInt(br.readLine());
			bags.offer(c);
		}

		while (!bags.isEmpty()) {
			int bag = bags.poll();

			while (!gems.isEmpty()) {
				Gem gem = gems.peek();

				if (gem.m > bag) break;

				gems.poll();
				values.offer(gem.v);
			}

			if (!values.isEmpty()) max += values.poll();
		}

		System.out.println(max);
	}

	static class Gem implements Comparable<Gem> {
		int m, v;

		Gem(int m, int v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(Gem o) {
			return this.m != o.m ? this.m - o.m : o.v - this.v;
		}
	}
}
