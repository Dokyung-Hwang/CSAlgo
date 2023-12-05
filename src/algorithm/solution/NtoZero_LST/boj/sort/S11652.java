package algorithm.solution.NtoZero_LST.boj.sort;

import algorithm.problem.baekjoon.sort.P11651;

import java.io.*;
import java.util.*;

public class S11652 implements P11651 {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<Long, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            long key = Long.parseLong(br.readLine());
            // 해당 키가 이미 맵에 존재하는지 확인
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.put(key, value + 1);
            } else {
                // 해당 키가 맵에 없는 경우, 초기값 1로 설정
                map.put(key, 1);
            }
        }
        long maxKey = 0, maxValue = 0;
        for(Map.Entry<Long, Integer> entry : map.entrySet()) {
            long key = entry.getKey();
            int value = entry.getValue();

            if(value > maxValue) {
                maxValue = value;
                maxKey = key;
            } else if (value == maxValue) {
                maxKey = Math.min(key, maxKey);
            }
        }
        System.out.println(maxKey);
    }
}
