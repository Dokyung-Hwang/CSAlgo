package algorithm.solution.dohyoungK.baekjoon.graph;

import algorithm.problem.baekjoon.graph.P2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2606 implements P2606 {
// TODO: 1번 컴퓨터로부터 바이러스 감염되는 컴퓨터 수 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
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
        deque.add(1);
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        int count = 0;
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            count++;

            for (int value : graph.getOrDefault(cur, new ArrayList<>())) {
                if (visited[value]) continue;
                deque.add(value);
                visited[value] = true;
            }
        }

        System.out.println(count - 1);
    }
}
