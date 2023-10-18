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

		함수의 흐름은 아래와 같다
		{15, 25, 22, 357, 16, 23, -53, 12, 46, 3}

		merge_sort(0, 10)
		{
			mid = 5, merge_sort(0, 5)
				{
					mid = 2, merge_sort(0, 2)
					{
						mid = 1, merge_sort(0, 1) return
					}
					-> merge_sort(2, 5)
					{
						mid = 3, merge_sort(2, 3) return
						-> merge_sort(3, 5)
						{
							mid = 4, merge_sort(3, 4) return
							-> merge_sort(4, 5) return
							-> merge(3, 5)
							{
								mid = 4, lidx = 3, ridx = 4
								ridx = 5, tmp = {0, 0, 0, 16}
								lidx = 4, tmp = {0, 0, 0, 16, 357}
								arr = {15, 25, 22, 16, 357, 23, -53, 12, 46, 3}
							}
						}
						-> merge(2, 5)
						{
							mid = 3, lidx = 2, ridx = 3
							ridx = 4, tmp = {0, 0, 16}
							lidx = 3, tmp = {0, 0, 16, 22}
							ridx = 5, tmp = {0, 0, 16, 22, 357}
							arr = {15, 25, 16, 22, 357, 23, -53, 12, 46, 3}
						}
					}
					-> merge(0, 5)
					{
						mid = 2, lidx = 0, ridx = 2
						lidx = 1, tmp = {15}
						ridx = 3, tmp = {15, 16}
						ridx = 4, tmp = {15, 16, 22}
						lidx = 2, tmp = {15, 16, 22, 25}
						ridx = 5, tmp = {15, 16, 22, 25, 357}
						arr = {15, 16, 22, 25, 35, 23, -53, 12, 46, 3}
					}
				}
			-> merge_sort(5, 10)
		}
	 */

	private static int n = 10;
	private static int[] arr = {15, 25, 22, 357, 16, 23, -53, 12, 46, 3};
	private static int[] tmp = new int[n];

	public static void main(String[] args) {
		System.out.println("정렬 전" + Arrays.toString(arr));
		merge_sort(0, n);
		System.out.println("정렬 후" + Arrays.toString(arr));
	}

	// mid = (st+en)/2라고 할 때
	// arr[st:mid], arr[mid:en]은 이미 정렬이 되어있는 상태일 때
	// arr[st:mid]와 arr[mid:en]을 합친다.
	static void merge(int st, int en){
		int mid = (st + en)/2;
		int lidx = st; // arr[st:mid]에서 값을 보기 위해 사용하는 index
		int ridx = mid; // arr[mid:en]에서 값을 보기 위해 사용하는 index
		for(int i = st; i < en; i++){
			if(ridx == en) tmp[i] = arr[lidx++];
			else if(lidx == mid) tmp[i] = arr[ridx++];
			else if(arr[lidx] <= arr[ridx]) tmp[i] = arr[lidx++];
			else tmp[i] = arr[ridx++];
		}
		for(int i = st; i < en; i++) arr[i] = tmp[i]; // tmp에 임시저장해둔 값을 a로 다시 옮김
	}

	// arr[st:en]을 정렬하고 싶다.
	static void merge_sort(int st, int en){
		if(en == st + 1) return; // 길이 1인 경우
		int mid = (st + en)/2;
		merge_sort(st, mid); // arr[st:mid]을 정렬한다.
		merge_sort(mid, en); // arr[mid:en]을 정렬한다.
		merge(st, en); // arr[st:mid]와 arr[mid:en]을 합친다.
	}
}
