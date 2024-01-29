package algorithm.solution.dohyoungK.baekjoon.graph;

import algorithm.problem.baekjoon.graph.P5567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S5567 implements P5567 {
// TODO: 자신의 결혼식에 초대할 사람의 수 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < m; i++) {
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
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        int count = 0;
        int friends = graph.getOrDefault(1, new ArrayList<>()).size() + 1; // 나와 나의 친구들 수
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            count++;

            for (int value : graph.getOrDefault(cur, new ArrayList<>())) {
                if (count > friends) continue;
                if (visited[value]) continue;
                deque.add(value);
                visited[value] = true;
            }
        }

        System.out.println(count - 1);
    }
}
