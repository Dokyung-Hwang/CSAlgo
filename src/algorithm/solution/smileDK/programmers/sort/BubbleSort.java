package algorithm.solution.smileDK.programmers.sort;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] arr) {
        return bubbleSort(arr, arr.length);
    }

    public static int[] bubbleSort(int[] arr, int size) {

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                }
            }
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 5, 6, 2, 4};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
}
