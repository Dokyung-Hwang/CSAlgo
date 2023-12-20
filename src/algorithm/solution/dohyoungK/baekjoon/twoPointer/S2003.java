package algorithm.solution.dohyoungK.baekjoon.twoPointer;

import algorithm.problem.baekjoon.twoPointer.P2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2003 implements P2003 {
// TODO:
//  N개의 수로 이루어진 수열에서 부분합이 M이 되는 경우의 수 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sequences = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int count = 0;
        int sum = 0;
        int end = 0;
        for (int start = 0; start < N; start++) {
            while (end < N && sum < M) {
                sum += sequences[end++];
            }

            if (sum == M) {
                count++;
            }

            sum -= sequences[start];
        }

        System.out.println(count);
    }
}
