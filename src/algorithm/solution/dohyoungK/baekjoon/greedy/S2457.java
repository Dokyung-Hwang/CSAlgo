package algorithm.solution.dohyoungK.baekjoon.greedy;

import algorithm.problem.baekjoon.greedy.P2457;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class S2457 implements P2457 {
// TODO: N개의 꽃 중 조건을 만족하는 최소 개수의 꽃 선택하기
//  3월 1일 ~ 11월 30일까지 매일 1가지 이상 꽃

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] flowers = new int[N][2];
        for (int i = 0; i < N; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            flowers[i] = new int[]{temp[0] * 100 + temp[1], temp[2] * 100 + temp[3]};
        }

        Arrays.sort(flowers, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });

        int start = 301;
        int index = 0;
        int maxEnd = 0;
        int count = 0;

        while (start < 1201) {
            boolean select = false;

            for (int i = index; i < N; i++) { // 다음 꽃 피는 날짜가 현재 지는 날짜보다 클 때 최댓값 찾기
                if (flowers[i][0] > start) {
                    break;
                }

                if (maxEnd < flowers[i][1]) {
                    select = true;
                    maxEnd = flowers[i][1];
                    index = i + 1;
                }
            }

            if (select) { // 다음 선택할 꽃이 있으면
                start = maxEnd;
                count++;
            } else {
                break;
            }
        }

        if (maxEnd < 1201) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }
    }
}
