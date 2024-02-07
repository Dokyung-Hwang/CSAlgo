package algorithm.solution.dohyoungK.baekjoon.greedy;

import algorithm.problem.baekjoon.greedy.P1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1931 implements P1931 {
// TODO: 한 개의 회의실의 회의실 사용표를 만들기
//  각 회의가 겹치지 않게 하면서 가능한 회의의 최대 개수 구하기

// TODO: 끝나는 시간 기준으로 가장 빠른 순으로 정렬
//  만약 같으면 시작 시간이 빠른 순으로 정렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<long[]> meetings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings.add(new long[]{Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())});
        }

        meetings.sort(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[1] < o2[1]) return -1;

                if (o1[1] == o2[1]) {
                    if (o1[0] < o2[0]) return -1;
                }

                return 1;
            }
        });

        int count = 0;
        long start = 0;
        for (int i = 0; i < N; i++) {
            long[] meeting = meetings.get(i);
            if (start > meeting[0]) continue; // 현재 시작 시간이 미팅 시작 시간 이후라면 무시
            count++;
            start = meeting[1];
        }

        System.out.println(count);
    }
}
