package algorithm.solution.dohyoungK.baekjoon.greedy;

import algorithm.problem.baekjoon.greedy.P2170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class S2170 implements P2170 {
//  TODO: 시작 작은 순, 끝 작은 순으로 정렬 후 다음 시작이 현재 끝보다 크면 길이 저장 후 새 시작 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] lines = new int[N][2];
        for (int i = 0; i < N; i++) {
            lines[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        Arrays.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        int end = lines[0][1];
        int length = lines[0][1] - lines[0][0];
        for (int i = 1; i < N; i++) {
            if (lines[i][0] <= end) {
                if (lines[i][1] <= end) continue;

                length += lines[i][1] - end;
                end = lines[i][1];
            } else {
                length += lines[i][1] - lines[i][0];
                end = lines[i][1];
            }
        }

        System.out.println(length);
    }
}
