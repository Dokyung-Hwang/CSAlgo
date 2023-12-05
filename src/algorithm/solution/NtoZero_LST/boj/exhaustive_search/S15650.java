package algorithm.solution.NtoZero_LST.boj.exhaustive_search;

import java.io.*;
import java.util.*;

public class S15650 {
    static int N, M;
    static int[] arr = new int[10];
    static boolean[] isUsed = new boolean[10];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        func(0, 1);

        System.out.println(sb.toString());
    }

    public static void func(int idx, int start) {
        if(idx==M) {
            for(int i=0; i<M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<=N; i++) { // i=start 제약조건
            if(!isUsed[i]) {
                arr[idx] = i;
                isUsed[i] = true;
                func(idx+1, i+1);
                isUsed[i] = false;
            }
        }
    }
}
