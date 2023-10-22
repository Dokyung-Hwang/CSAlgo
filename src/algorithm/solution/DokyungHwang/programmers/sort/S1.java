package algorithm.solution.DokyungHwang.programmers.sort;

import algorithm.problem.programmers.sort.P1;

import java.util.Arrays;

public class S1 implements P1 {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] cmd = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = solution(arr, cmd);
        System.out.println(cmd.length);
        printArray(result);
    }

    public static int[] bestSolution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            sort(temp, 0, temp.length - 1);
            answer[i] = temp[commands[i][2]-1];
        }
        return answer;
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int x = 0; x < commands.length; x++) {
            int i = commands[x][0];     // 2 4 1
            int j = commands[x][1];     // 5 4 7
            int k = commands[x][2];     // 3 1 3

            // index:  0  1  2  3  4  5  6
            // arr  = {1, 5, 2, 6, 3, 7, 4}
            // sliceArr =    {5, 2, 6, 3}
            // i=2(이상) <-> array[1]
            // j=5(미만) <-> array[4]
            int[] sliceArr = Arrays.copyOfRange(array, i-1, j);
            // copyOfRange: 배열을 원하는 범위만큼 잘라서 복사
            // 문법 : copyOfRange(복사할 배열, 시작인덱스(이상), 끝인덱스(미만))


            // Quick Sort
            // 시작점 인덱스는 0 끝 인덱스는 sliceArr 배열의 끝까지
            sort(sliceArr, 0, sliceArr.length - 1);
            answer[x] = sliceArr[k-1];
        }
        return answer;
    }

    // Quick Sort(array, 시작점, 끝점)
    public static void sort(int[] a, int left, int right){
        int start = left;           // Start Point
        int end = right;            // End Point
        int pivot = a[(start+end)/2];       // Pivot

        do{                                         // 실행문
            while(a[start] < pivot)
                start++;        // 시작 값이 Pivot보다 작으면 무시하고 넘어감 start++
            while(a[end] > pivot)
                end--;            // 끝 값이 Pivot보다 크면 무시하고 넘어감 end--
            if(start <= end){                       // start가 end와 같거나 작은지 확인
                int temp = a[start];                // start와 end를 Swap
                a[start] = a[end];
                a[end] = temp;
                start++;                            // 한칸씩 이동
                end--;                              // 한칸씩 이동
            }
        }while(start <= end);

        // 재귀
        if(left < end)
            sort(a, left, end);
        if(right > start)
            sort(a, start, right);
    }


    // 출력해주는 메소드
    public static void printArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
