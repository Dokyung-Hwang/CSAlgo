package algorithm.solution.NtoZero_LST.boj.exhaustive_search;

import algorithm.problem.baekjoon.backTracking.P1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1182 implements P1182 {
    static int N, S;
    static int[] arr;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[100];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);
        if(S==0) count--; // S가 0일 때 빈 칸을 포함하는 부분수열도 세는 것을 방지
        System.out.println(count);
    }

    public static void func(int curIdx, int total) {
        if(curIdx == N) {
            if(total == S) count++;
            return;
        }
        func(curIdx+1, total); // 현재 인덱스 원소 부분수열에 포함X
        func(curIdx+1, total + arr[curIdx]); // 현재 원소 부분수열에 포함
    }
}
