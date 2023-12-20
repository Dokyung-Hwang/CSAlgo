package algorithm.solution.dohyoungK.baekjoon.twoPointer;

import algorithm.problem.baekjoon.twoPointer.P2230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2230 implements P2230 {
// TODO:
//  N개의 수로 이루어진 수열에서
//  두 수를 골랐을 때 그 차이가 M 이상이면서
//  제일 작은 경우 구하기

// TODO:
//  투 포인터로 차이가 M 이상인 경우를 찾으면서
//  그 차이들 중 min 값 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sequences = new int[N];

        for (int i = 0; i < N ; i++) {
            sequences[i] = Integer.parseInt(br.readLine());
        }
        sequences = Arrays.stream(sequences)
                .sorted()
                .toArray();

        int result = 2000000001;
        int end = 0;
        for (int start = 0; start < N; start++) {
            while (end < N && sequences[end] - sequences[start] < M) {
                end++;
            }
            if (end == N) break;

            result = Math.min(result, sequences[end] - sequences[start]);

            if (result == M) {
                System.out.println(result);
                return;
            }
        }

        System.out.println(result);
    }
}
