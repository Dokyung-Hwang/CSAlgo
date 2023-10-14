package algorithm.reference.sort;

import java.util.Arrays;

public class QuickSort {
	/*
		https://www.youtube.com/watch?v=59fZkZO0Bo4&list=PLtqbFd2VIQv4O6D6l9HcD732hdrnYb6CY&index=15
		해당 강의에서 설명 하는 병합 정렬을 자바로 구현한 코드
		시간 복잡도 : O(NlogN) 혹은 O(N^2)

		자바에서 제공해주는 Arrays.sort 메서드는 DualPivotQuickSort를 사용함
		기본으로 제공해주는 정렬 메서드를 사용하면 안되는 조건이 붙은
		정렬 문제가 주어졌다면 퀵 정렬보다는 병합 정렬을 사용하는 것을 추천
		(구현이 어려움...)

		Pivot을 하나 선택하여 매 연산마다 피봇을 제자리로 보내는 정렬 방법으로
		피봇은 보통 맨 왼쪽에 있는 0번 인덱스의 값을 사용 함(다른 인덱스를 사용해도 문제 없음)

		피봇을 선택했으면 피봇의 왼쪽에는 피봇보다 작은 값을, 오른쪽에는 큰 값을 위치시키고
		반으로 나누어 정렬하면 됨

		추가적인 공간을 사용하지 않는 In-Place Sort 방식을 사용하여
		Cache Hit Rate가 높은게 퀵 정렬의 장점이라 이를 살려서 구현해야 함

		추가적인 공간을 사용하지 않기 위해 두 개의 포인터를 사용하여
		작은 값과 큰 값을 구분

	*/

	private static int n = 10;

	private static int arr[] = {15, 25, 22, 357, 16, 23, -53, 12, 46, 3};

	public static void main(String[] args) {

		System.out.println("정렬 전" + Arrays.toString(arr));
		quickSort(0, n);
		System.out.println("정렬 후" + Arrays.toString(arr));
	}

	private static void quickSort(int st, int en) {
		if (en <= st + 1) return;

		int pivot = arr[st];
		int l = st + 1;
		int r = en - 1;

		while (true) {
			while (l <= r && arr[l] <= pivot) l++;
			while (l <= r && arr[r] >= pivot) r--;
			if (l > r) break;
			swap(l, r);
		}

		swap(st, r);

		quickSort(st, r);

		quickSort(r + 1, en);
	}

	private static void swap(int l, int r) {
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}
}
