package algorithm.solution.NtoZero_LST.boj.sort;

import algorithm.problem.baekjoon.sort.P5648;

import java.util.*;
import java.io.*;

public class S5648 implements P5648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];

        int count = 0;
        while (true) {
            if (st.hasMoreTokens()) {
                arr[count++] = Long.parseLong(st.nextToken());
                if (count == N) break;
            } else {
                st = new StringTokenizer(br.readLine());
            }
        }
//        while ( count < N) {
//            if(!st.hasMoreTokens()) {
//                st = new StringTokenizer(br.readLine());
//            }
//            arr[count] = Long.parseLong(st.nextToken());
//            count++;
//        }

        // 역원소
        for(int i=0; i<N; i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(arr[i])).reverse();
            arr[i] = Long.parseLong(sb.toString());
        }

        // 정렬 nlogn
        Arrays.sort(arr);

        for(long l : arr) {
            bw.write(l+"\n");
        }
        bw.close();
    }
}
