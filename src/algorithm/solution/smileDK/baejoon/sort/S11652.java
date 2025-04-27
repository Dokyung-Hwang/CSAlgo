package algorithm.solution.smileDK.baejoon.sort;

import algorithm.problem.baekjoon.sort.P11652;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class S11652 implements P11652 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long M = Long.parseLong(br.readLine());
            map.put(M, map.getOrDefault(M, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        long answer = 0;
        for(long x: map.keySet()) {
            if(map.get(x) > max) {
                max = map.get(x);
                answer = x;
            } else if(map.get(x) == max) {
                answer = Math.min(answer, x);
            }
        }

        System.out.println(answer);
    }
}
