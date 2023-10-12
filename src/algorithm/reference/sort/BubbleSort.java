package algorithm.reference.sort;

import java.util.Arrays;

public class BubbleSort {
	/*
		https://www.youtube.com/watch?v=59fZkZO0Bo4&list=PLtqbFd2VIQv4O6D6l9HcD732hdrnYb6CY&index=15
		해당 강의에서 설명하는 버블 정렬을 자바로 구현한 코드
		시간 복잡도 : O(N^2)

		기본 정렬을 기준으로 버블 정렬은 현재 원소와 다음 원소를 비교 하여
		다음 원소가 더 작다면 두 인덱스의 값을 서로 바꿔 주는걸 반복 하여
		가장 큰 값을 마지막 인덱스로 보내고
		이를 계속 반복 하여 정렬 하는 방법이다.

		배열 {2, 13, 6, 4, -2}를 버블 정렬을 이용 해서 정렬 하려면
		아래와 같은 순서대로 진행 된다.

		[2, 13, 6, 4, -2]
		[2, 6, 13, 4, -2]
		[2, 6, 4, 13, -2]
		[2, 6, 4, -2, 13]
		[2, 6, 4, -2, 13]
		[2, 4, 6, -2, 13]
		[2, 4, -2, 6, 13]
		[2, 4, -2, 6, 13]
		[2, -2, 4, 6, 13]
		[-2, 2, 4, 6, 13]
	 */

	public static void main(String[] args) {
		int[] arr = {2, 13, 6, 4, -2};
		int n = arr.length;

		System.out.println("정렬 전 : " + Arrays.toString(arr));

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
				System.out.println(Arrays.toString(arr));
			}
		}

		System.out.println("정렬 후 : " + Arrays.toString(arr));
	}
}
