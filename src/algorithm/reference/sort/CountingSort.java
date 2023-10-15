package algorithm.reference.sort;

import java.util.Arrays;

public class CountingSort {
	/*
		https://www.youtube.com/watch?v=59fZkZO0Bo4&list=PLtqbFd2VIQv4O6D6l9HcD732hdrnYb6CY&index=15
		해당 강의에서 설명 하는 카운팅 정렬을 자바로 구현한 코드

		주어진 숫자의 범위만큼 배열을 만든 후에
		해당 배열에 숫자의 등장 여부를 카운트하고
		각 숫자들의 등장 횟수만큼 순서대로 정렬하는 방법으로
		구현이 매우 간단하다는 장점이 있지만
		수의 범위가 큰 경우에는 그만큼 큰 배열을 사용해야 하고
		수의 범위를 예상할 수 없다면 배열의 크기를 지정할 수 없기에
		수의 범위가 한정적이고 작은 경우에 효율적이다.

		보통 수의 범위는 1000만 이하까지만 카운팅 정렬을 사용하는 것이 좋다.
	 */

	private static int[] arr = {5, 10, 7, 8, 25, 20, 21, 19, 33, 28};
	private static int[] tmp = new int[34];

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		System.out.println("정렬 후 : " + Arrays.toString(arr));

		for (int a : arr) {
			tmp[a]++;
		}

		for (int i = 1; i < tmp.length; i++) {
			if (tmp[i] > 0) {
				for (int j = 0; j < tmp[i]; j++) {
					sb.append(i).append(" ");
				}
			}
		}

		System.out.println("정렬 후 : " + sb);
	}
}
