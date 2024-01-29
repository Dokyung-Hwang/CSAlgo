package algorithm.solution.dohyoungK.baekjoon.graph;

import algorithm.problem.baekjoon.graph.P11724;
import algorithm.solution.dohyoungK.baekjoon.bfs.S1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S11724 implements P11724 {
// TODO: 방향 없는 그래프에서 연결 요소의 개수 구하기
// TODO: 간선이 없는 노드 수도 포함되어야 함

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            List<Integer> uValue = graph.getOrDefault(u, new ArrayList<>());
            List<Integer> vValue = graph.getOrDefault(v, new ArrayList<>());
            uValue.add(v);
            vValue.add(u);
            graph.put(u, uValue);
            graph.put(v, vValue);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                deque.add(i);
                visited[i] = true;
            }

            while (!deque.isEmpty()) {
                int current = deque.pollFirst();

                for (int value : graph.getOrDefault(current, new ArrayList<>())) {
                    if (!visited[value]) {
                        deque.add(value);
                        visited[value] = true;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
