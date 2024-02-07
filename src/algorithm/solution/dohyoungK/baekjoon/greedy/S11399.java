package algorithm.solution.dohyoungK.baekjoon.greedy;

import algorithm.problem.baekjoon.greedy.P11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S11399 implements P11399 {
// TODO: 각 사람이 돈을 인출하는 데 걸리는 시간을 입력받아
//  모든 사람이 돈을 인출하는 데 걸리는 시간의 최소 합을 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(P);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += P[i] * (N - i);
        }

        System.out.println(sum);
    }
}
