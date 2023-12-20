package algorithm.solution.dohyoungK.baekjoon.twoPointer;

import algorithm.problem.baekjoon.twoPointer.P1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1806 implements P1806 {
// TODO:
//  N 개의 수의 수열에서 연속된 수의 부분합 중
//  그 합이 S이상이 되는 것 중, 길이가 가장 짧은 것 길이 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] sequences = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int minLength = 100001;
        int sum = sequences[0];
        int end = 0;
        Loop:
        for (int start = 0; start < N; start++) {
            while (end < N && sum < S) {
                end++;
                if (end == N) break Loop;
                sum += sequences[end];
            }

            minLength = Math.min(minLength, end - start + 1);
            sum -= sequences[start];
        }

        if (minLength == 100001) {
            System.out.println(0);
            return;
        }
        System.out.println(minLength);
    }
}
