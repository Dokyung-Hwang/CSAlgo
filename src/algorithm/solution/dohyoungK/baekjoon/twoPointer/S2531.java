package algorithm.solution.dohyoungK.baekjoon.twoPointer;

import algorithm.problem.baekjoon.twoPointer.P2531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S2531 implements P2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N + k - 1];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        for (int i = N; i < N + k - 1; i++) {
            sushi[i] = sushi[idx++];
        }

        int end = 0;
        int count = 0; // 연속 접시 수
        int result = 0; // 먹을 수 있는 최대 가짓 수
        HashMap<Integer, Integer> hm = new HashMap<>(); // 각 종류의 스시가 몇접시 등장했는지, hm.size가 중복되지 않은 접시 수
        for (int start = 0; start < N + k - 1; start++) {
            while (end < N + k - 1 && count < k) {
                if (!hm.containsKey(sushi[end])) {
                    hm.put(sushi[end], 1);
                } else {
                    hm.put(sushi[end], hm.get(sushi[end]) + 1);
                }
                end++;
                count++;
            }

            if (!hm.containsKey(c)) {
                result = Math.max(result, hm.size() + 1);
            } else {
                result = Math.max(result, hm.size());
            }

            if (hm.get(sushi[start]) == 1) {
                hm.remove(sushi[start]);
            } else {
                hm.put(sushi[start], hm.get(sushi[start]) - 1);
            }
            count--;
        }

        System.out.println(result);
    }
}
