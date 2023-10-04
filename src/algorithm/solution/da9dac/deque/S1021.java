package algorithm.solution.da9dac.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import algorithm.problem.deque.P1021;

public class S1021 implements P1021 {
	// https://da9dac.tistory.com/178

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer input1 = new StringTokenizer(br.readLine());
		List<String> orders = Arrays.stream(br.readLine().split(" "))
			.collect(Collectors.toList());

		int n = Integer.parseInt(input1.nextToken());
		int m = Integer.parseInt(input1.nextToken());

		int[] result = new int[m];
		int idx = 0;

		int count = 0;

		LinkedList<Integer> deque = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			deque.offer(i);
		}

		while (idx <= m - 1) {
			String order = orders.get(idx);
			int targetIdx = deque.indexOf(Integer.parseInt(order));

			while (!(deque.peekFirst() + "").equals(order)) {
				int mid = (int)(deque.size() / 2.0);

				if (targetIdx <= mid) {
					deque.offerLast(deque.poll());
					count++;
				} else if (targetIdx > mid){
					deque.offerFirst(deque.pollLast());
					count++;
				} else {
					deque.poll();
				}
			}

			if ((deque.peekFirst() + "").equals(order)) {
				result[idx++] = deque.poll();
			}
		}

		System.out.println(count);
	}
}
