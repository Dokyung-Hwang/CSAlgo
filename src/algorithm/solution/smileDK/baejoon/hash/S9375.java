package algorithm.solution.smileDK.baejoon.hash;

import algorithm.problem.baekjoon.hash.P9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S9375 implements P9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hashMap = new HashMap<>();

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                hashMap.put(type, hashMap.getOrDefault(type, 0) + 1);
            }

            int result = theNumberOfTheCases(hashMap);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static int theNumberOfTheCases(Map<String, Integer> typeCount) {
        int result = 1;

        for (int value : typeCount.values()) {
            result *= value + 1;
        }

        // 아무 것도 선택하지 않은 경우 null, null
        return result - 1;
    }
}
