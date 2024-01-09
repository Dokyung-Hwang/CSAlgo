package algorithm.solution.dohyoungK.baekjoon.greedy;

import algorithm.problem.baekjoon.greedy.P2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2217 implements P2217 {
// TODO: N개의 로프를 입력받아
//  각 로프를 병렬로 이용해 들어올릴 수 있는 최대 중량 구하기

// TODO: 로프가 들 수 있는 중량이 작은 순으로 정렬한 뒤
//  병렬로 로프를 이용했을 때 중량이 큰 것을 찾기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] ropes = new int[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);
        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, ropes[i] * (ropes.length - i)); // 중량이 작은 순으로 빼면서 이후에 최대 중량이 나오는지 확인
        }

        System.out.println(result);
    }
}
