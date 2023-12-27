package algorithm.solution.dohyoungK.baekjoon.twoPointer;

import algorithm.problem.baekjoon.twoPointer.P13144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class S13144 implements P13144 {
// TODO:
//  길이 N의 수열에서 연속한 1개 이상의 수를 뽑았을 때
//  같은 수가 여러번 등장하지 않는 경우의 수 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sequences = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        HashMap<Integer, Boolean> hm = new HashMap<>(); // 이전에 등장하는 수 확인용
        long count = 0L;
        int end = 0;
        for (int start = 0; start < N; start++) {
            while (end < N) {
                if (!hm.getOrDefault(sequences[end], false)) {
                    hm.put(sequences[end++], true);
                } else {
                    hm.remove(sequences[start]);
                    count += end - start;
                    break;
                }
            }

            if (end == N) count += end - start;
        }

        System.out.println(count);
    }
}
