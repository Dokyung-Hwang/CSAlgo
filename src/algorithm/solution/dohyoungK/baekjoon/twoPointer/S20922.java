package algorithm.solution.dohyoungK.baekjoon.twoPointer;

import algorithm.problem.baekjoon.twoPointer.P20922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S20922 implements P20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] sequences = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = 0;
        int end = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int start = 0; start < N; start++) {
            while (end < N && hm.getOrDefault(sequences[end], 0) < K) {
                if (!hm.containsKey(sequences[end])) {
                    hm.put(sequences[end], 1);
                } else {
                    hm.put(sequences[end], hm.get(sequences[end]) + 1);
                }

                end++;
            }

            result = Math.max(result, end - start);

            hm.put(sequences[start], hm.get(sequences[start]) - 1);
        }

        System.out.println(result);
    }
}
