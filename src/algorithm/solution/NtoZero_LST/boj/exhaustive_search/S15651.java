package algorithm.solution.NtoZero_LST.boj.exhaustive_search;

import algorithm.problem.baekjoon.backTracking.P15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S15651 implements P15651 {
    static int N, M;
    static int[] arr = new int[10];
    static boolean[] isUsed = new boolean[10]; //사용 할 필요 없음 (중복 순열)
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        func(0);
        System.out.println(sb.toString());
    }

    public static void func(int k) {
        if( k == M) {
            for (int i=0; i<M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i<= N; i++) {
            arr[k] = i;
            func(k+1);
        }
    }
}
