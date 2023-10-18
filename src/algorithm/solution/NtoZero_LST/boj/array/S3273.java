package algorithm.solution.NtoZero_LST.boj.array;


import algorithm.problem.baejoon.array.P3273;

import java.io.*;
import java.util.Arrays;

public class S3273 implements P3273 {
    public static void main(String[] args) throws IOException {
        /*
            시간 제한 1초, 메모리 제한 128Mb, N 10^5, X 2*10^6
            시간 복잡도 : O(NlogN) 이하 가능 -> (10^5) * (20.x)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // n, 배열의 요소 개수
        int n = Integer.parseInt(br.readLine());
        // 숫자 배열 arr
        int[] arr = new int[n];
        String[] stringArr = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.valueOf(stringArr[i]);
        }
        // x, 서로 다른 두 수의 합이 되는 기준 x
        int x = Integer.parseInt(br.readLine());


        // 조건을 만족하는 경우의 수 count
        int count = 0;

        // 시간 복잡도 nlogn 이하로 풀이 해야하므로, 버블, 선택, 삽입 정렬 불가능 -> 투 포인터 사용
        // 투 포인터를 사용하기 위한 라이브러리 정렬 (퀵 정렬, nlog(n))
        Arrays.sort(arr);
        int start = 0;          //시작 인덱스
        int end = arr.length-1; // 끝 인덱스

        while(start < end) {
            int sum = arr[start]+arr[end];
            //탈출 조건 : start 인덱스와 end 인덱스가 만날 때
            if(start==end) break;

            if(sum>x) {
                end--;
            } else if(sum==x) {
                count++;
                start++;
                end--;
            } else { //sum<x
                start++;
            }

        }

        bw.write(String.valueOf(count));
        bw.close();
    }
}
