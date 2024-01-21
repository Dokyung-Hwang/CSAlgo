package algorithm.reference.queue;

public class PriorityQueue {
	int[] heap;
	int size = 0;

	public PriorityQueue(int size) {
		this.heap = new int[size];
	}

	void push(int x) {
		heap[++size] = x;
		int idx = size;

		while (idx != 1) {
			int cur = idx/2;

			if (heap[cur] <= heap[idx]) break;

			swap(cur, idx);

			idx = cur;
		}
	}

	int top() {
		return heap[1];
	}

	void pop() {
		heap[1] = heap[size--];
		int idx = 1;

		while (2 * idx <= size) {
			int left = 2*idx;
			int right = left + 1;
			int min = left;

			if (right <= size && heap[right] < heap[left]) min = right;
			if (heap[idx] <= heap[min]) break;

			swap(idx, min);

			idx = min;
		}
	}

	void swap(int cur, int idx) {
		int tmp = heap[cur];
		heap[cur] = heap[idx];
		heap[idx] = tmp;
	}
}
