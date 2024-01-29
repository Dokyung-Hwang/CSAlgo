package algorithm.solution.dohyoungK.baekjoon.graph;

import algorithm.problem.baekjoon.graph.P11403;

import java.io.*;
import java.util.*;

public class S11403 implements P11403 {
// TODO: 가중치 없는 방향 그래프에서 모든 정점에 대해
//  i -> j까지 가는 길이가 양수인 경로가 있는지 없는지 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            List<Integer> value = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (arr[j] == 1) value.add(j);
            }
            graph.put(i, value);
        }

        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            Deque<Integer> deque = new ArrayDeque<>();
            deque.add(i);
            int[] visited = new int[N]; // 시작점을 체크 안해야 다시 돌아오는지 확인 가능

            while (!deque.isEmpty()) {
                int cur = deque.poll();

                for (int value : graph.getOrDefault(cur, new ArrayList<>())) {
                    if (visited[value] == 1) continue;
                    deque.add(value);
                    visited[value] = 1;
                }
            }

            result[i] = visited;
        }

        for (int[] arr : result) {
            for (int e : arr) {
                bw.write(e + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}

// 1 -> 4
// 2 -> 7
// 4 -> 5
// 4 -> 6
// 5 -> 1
// 6 -> 7
// 7 -> 3