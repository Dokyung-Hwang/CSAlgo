package algorithm.solution.DokyungHwang.programmers.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        System.out.println("=============정렬 전=============");
        printArray(arr);
        quickSort(arr);
        System.out.println("=============정렬 후=============");
        printArray(arr);
    }

    private static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
        // 정렬할 배열, 시작점, 끝점 -> 재귀함수 호출
    }

    // 재귀 함수
    private static void quickSort(int[] arr, int start, int end){
        int part2 = partition(arr, start, end);     // part2 = 1
        if (start < part2 - 1) {
            quickSort(arr, start, part2 - 1);
        }

        if (part2 < end) {
            quickSort(arr, part2, end);
        }
    }
    // arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2}
    private static int partition(int[] arr, int start, int end){
        int pivot = arr[(start + end) / 2];
        while(start <= end) {
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
            if(start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    // Start와 end를스왑
    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    private static void printArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
