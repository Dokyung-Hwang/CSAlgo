package algorithm.reference.sort;

import java.util.Arrays;

public class SelectionSort {
	/*
		https://www.youtube.com/watch?v=59fZkZO0Bo4&list=PLtqbFd2VIQv4O6D6l9HcD732hdrnYb6CY&index=15
		해당 강의에서 설명하는 선택 정렬을 자바로 구현한 코드
		시간 복잡도 : O(N^2)

		가장 큰 원소를 찾아 뒤로 보내거나 (기본 정렬)
		가장 작은 원소를 찾아 뒤로 보내는걸 (역순 정렬)
		계속 반복해준다.

		이때 처음에는 n-1번 반복하고 그 다음에는 n - 2, n - 3, ...
		순으로 반복 횟수는 점점 줄어든다.

		진행 과정은 아래와 같다.

		3, 2, 7, 116, 62, 235, 1, 23, 55, 77
		3, 2, 7, 116, 62, 77, 1, 23, 55, 235
		3, 2, 7, 55, 62, 77, 1, 23, 116, 235
		3, 2, 7, 55, 62, 23, 1, 77, 116, 235
		3, 2, 7, 55, 1, 23, 62, 77, 116, 235
		3, 2, 7, 23, 1, 55, 62, 77, 116, 235
		3, 2, 7, 1, 23, 55, 62, 77, 116, 235
		3, 2, 1, 7, 23, 55, 62, 77, 116, 235
		1, 2, 3, 7, 23, 55, 62, 77, 116, 235
	 */

	private static int[] reverse =
		{3, 2, 7, 116, 62, 235, 1, 23, 55, 77};
	private static int[] normal =
		{3, 2, 7, 116, 62, 235, 1, 23, 55, 77};

	public static void main(String[] args) {
		sort();
		reverseSort();
	}

	private static void sort() {
		System.out.println("일반 선택 정렬");
		System.out.println("정렬 전 : " + Arrays.toString(normal));

		for (int i = normal.length - 1; i > 0; i--) {
			int maxIndex = 0;

			for (int j = 1; j <= i; j++) {
				if (normal[maxIndex] < normal[j]) {
					maxIndex = j;
				}
			}

			int temp = normal[i];
			normal[i] = normal[maxIndex];
			normal[maxIndex] = temp;
			System.out.println(Arrays.toString(normal));
		}

		System.out.println("정렬 후 : " + Arrays.toString(normal));
	}

	private static void reverseSort() {
		System.out.println("역순 선택 정렬");
		System.out.println("정렬 전 : " + Arrays.toString(reverse));

		for (int i = reverse.length - 1; i > 0; i--) {
			int maxIndex = 0;

			for (int j = 1; j <= i; j++) {
				if (reverse[maxIndex] > reverse[j]) {
					maxIndex = j;
				}
			}

			int temp = reverse[i];
			reverse[i] = reverse[maxIndex];
			reverse[maxIndex] = temp;
			System.out.println(Arrays.toString(reverse));
		}

		System.out.println("정렬 후 : " + Arrays.toString(reverse));
	}
}
