package algorithm.solution.NtoZero_LST.boj.exhaustive_search;

import algorithm.problem.baekjoon.backTracking.P15649;

import java.io.*;
import java.util.*;

public class S15649 implements P15649 {

    static int N, M;
    static int[] arr = new int[10]; // 수열을 담을 배열
    static boolean[] isUsed = new boolean[10]; // 특정 수가 사용되었는지 true or false로 출력

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        func(0);
        System.out.println(sb.toString());
    }

    public static void func(int k) { // 현재 k개까지의 수를 선택함
        if(k == M) { // k가 M에 도달하면
            for(int i = 0; i <M; i++) { //지금까지 기록한 수를 출력
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i<=N; i++) { //1부터 N까지 수
            if(!isUsed[i]) { // 숫자 'i'가 사용되지 않았으면
                arr[k] = i; // k번째 수가 i임
                isUsed[i] = true; // i를 사용했다고 표시한다.
                func(k+1); // 다음 수를 정하러 한 단계 더 재귀
                isUsed[i] = false; // 재귀를 끝내고 돌아오면 i를 사용하지 않았다고 재표시
            }
        }
    }
}
