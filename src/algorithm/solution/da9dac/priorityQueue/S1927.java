package algorithm.solution.da9dac.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import algorithm.problem.baekjoon.priorityQueue.P1927;

public class S1927 implements P1927 {
	// https://da9dac.tistory.com/291

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		MinHeap minHeap = new MinHeap();

		while (n-- > 0) {
			int x = Integer.parseInt(br.readLine());

			if (x != 0) minHeap.offer(x);
			else sb.append(minHeap.poll()).append("\n");
		}

		System.out.println(sb);
	}

	private static class MinHeap {
		int[] heap = new int[100001];
		int size = 0;

		void offer(int x) {
			heap[++size] = x;
			int idx = size;

			while (idx != 1) {
				int cur = idx/2;

				if (heap[idx] > heap[cur]) break;

				swap(idx, cur);

				idx = cur;
			}
		}

		int poll() {
			if (size == 0) return 0;

			int r = heap[1];
			heap[1] = heap[size--];
			int idx = 1;

			while (idx * 2 <= size) {
				int left = idx * 2;
				int right = left + 1;
				int min = left;

				if (right <= size && heap[right] < heap[left]) min = right;
				if (heap[min] >= heap[idx]) break;

				swap(min, idx);

				idx = min;
			}

			return r;
		}

		void swap(int x, int y) {
			int tmp = heap[x];
			heap[x] = heap[y];
			heap[y] = tmp;
		}
	}
}
