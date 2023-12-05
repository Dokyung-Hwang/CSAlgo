package algorithm.solution.dohyoungK.baekjoon.sort;

import algorithm.problem.baekjoon.sort.P7795;

import java.io.*;
import java.util.*;

public class S7795 implements P7795 {
// TODO:
//  A와 B배열을 입력받아 A의 원소가 B의 원소보다 큰 조합 개수 찾기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int[] A = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            int[] B = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            int result = 0;
            int index = M - 1;

            for (int j = N - 1; j >= 0; j--) {
                for (int k = index; k >= 0; k--) {
                    if (A[j] > B[k]) {
                        result += k + 1;
                        break;
                    }
                }
            }
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }
}
