package algorithm.solution.dohyoungK.baekjoon.hash;

import algorithm.problem.baekjoon.hash.P9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class S9375 implements P9375 {
// TODO:
//  여러 의상들이 주어졌을 때
//  옷 조합 구하기 (예전 프로그래머스 문제)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            // 옷 종류별 개수
            HashMap<String, Integer> hm = new HashMap<>();

            for (int j = 0; j < n; j++) {
                String clothesType = br.readLine().split(" ")[1];
                hm.put(clothesType, hm.getOrDefault(clothesType, 0) + 1);
            }

            List<Integer> values = hm.values().stream().collect(Collectors.toList());

            if (values.size() == 1) {
                System.out.println(values.get(0));
                continue;
            }

            int sum = 1;
            for (int value : values) {
                sum *= value + 1;
            }
            System.out.println(sum - 1);
        }
    }
}
