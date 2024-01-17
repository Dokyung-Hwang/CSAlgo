package algorithm.solution.smileDK.baejoon.greedy;

import algorithm.problem.baekjoon.backTracking.P1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1931 implements P1941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // times[][0] = 회의 시작
        // times[][1] = 회의 종료

        int[][] times = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }


        // 회의 종료 시점을 기준으로 정렬
        Arrays.sort(times, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });

        int count = 0;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            if (temp <= times[i][0]) {
                temp = times[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
