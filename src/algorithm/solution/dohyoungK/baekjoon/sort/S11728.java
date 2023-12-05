package algorithm.solution.dohyoungK.baekjoon.sort;

import algorithm.problem.baekjoon.sort.P11728;

import java.io.*;
import java.util.Arrays;

public class S11728 implements P11728 {
// TODO:
//  정렬된 두 배열 입력받아 합친 배열을 정렬해서 출력
//  if문으로 배열 맨 앞의 수들 비교하는거보다 stream sort가 빠르네

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] B = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; i < N + M; i++) {
            if (aIndex == N) bw.write(B[bIndex++] + " ");
            else if (bIndex == M) bw.write(A[aIndex++] + " ");
            else if (A[aIndex] > B[bIndex]) bw.write(B[bIndex++] + " ");
            else if (A[aIndex] <= B[bIndex]) bw.write(A[aIndex++] + " ");
        }

        bw.flush();
        bw.close();
    }
}
