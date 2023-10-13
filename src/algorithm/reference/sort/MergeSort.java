package algorithm.reference.sort;

import java.util.Arrays;

public class MergeSort {
	/*
		https://www.youtube.com/watch?v=59fZkZO0Bo4&list=PLtqbFd2VIQv4O6D6l9HcD732hdrnYb6CY&index=15
		해당 강의에서 설명 하는 병합 정렬을 자바로 구현한 코드
		시간 복잡도 : 분할 (O(N)) + 병합 (O(NlogN)) = O(NlogN)

		[6, -8, 1, 12, 8, 15, 7, -7]
		위와 같은 배열을 정렬할 때
		배열을 반으로 나누고 나눠서
		6, -8, 1, 12, 8, 15, 7, -7
		위와 같이 각각의 원소로 만든 후에
		6, -8을 비교 하고 1, 12를 비교 하면서
		정렬 하고 다시 병합 하는 과정을 반복 하여
		정렬된 배열을 만드는 방식

		정렬 과정은 아래와 같다.

		[6, -8, 1, 12, 8, 15, 7, -7]
		[6, -8, 1, 12] [8, 15, 7, -7]
		[6, -8] [1, 12] [8, 15] [7, -7]
		[6] [8] [1] [12] [8] [15] [7] [-7]
		[-8, 6] [1, 12] [8, 15] [-7, 7]
		[-8, 1, 6, 12] [-7, 7, 8, 15]
		[-8, -7, 1, 6, 7, 8, 12, 15]
	 */

	private static int n = 10;
	private static int[] arr = {15, 25, 22, 357, 16, 23, -53, 12, 46, 3};
	private static int[] temp = new int[n];

	public static void main(String[] args) {
		System.out.println("정렬 전" + Arrays.toString(arr));
		merge_sort(0, n);
		System.out.println("정렬 후" + Arrays.toString(arr));
	}

	// mid = (st+en)/2라고 할 때
	// arr[st:mid], arr[mid:en]은 이미 정렬이 되어있는 상태일 때
	// arr[st:mid]와 arr[mid:en]을 합친다.
	static void merge(int st, int en){
		int mid = (st+en)/2;

		for (int i = 0; i < en - st; i++) {

		}
	}

	// arr[st:en]을 정렬하고 싶다.
	static void merge_sort(int st, int en){
		if(en - st == 1) return; // 길이 1인 경우
		int mid = (st+en)/2;
		merge_sort(st, mid); // arr[st:mid]을 정렬한다.
		merge_sort(mid, en); // arr[mid:en]을 정렬한다.
		merge(st, en); // arr[st:mid]와 arr[mid:en]을 합친다.
	}
}
