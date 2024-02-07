package algorithm.solution.dohyoungK.baekjoon.graph;

import algorithm.problem.baekjoon.graph.P2617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2617 implements P2617 {
// TODO: 구슬 중 중간 무게의 구슬이 될 수 없는 구슬의 개수 구하기

    static int N;
    static int result = 0;
    static int limit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, List<Integer>> minGraph = new HashMap<>(); // key 보다 무거운 것들 모음
        HashMap<Integer, List<Integer>> maxGraph = new HashMap<>(); // key 보다 가벼운 것들 모음
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            List<Integer> uValue = minGraph.getOrDefault(u, new ArrayList<>());
            List<Integer> vValue = maxGraph.getOrDefault(v, new ArrayList<>());
            uValue.add(v);
            vValue.add(u);
            minGraph.put(u, uValue);
            maxGraph.put(v, vValue);
        }

        limit = N / 2; // 중간값이 될 수 없는 리미트
        bfs(minGraph);
        bfs(maxGraph);

        System.out.println(result);
    }

    public static void bfs(HashMap<Integer, List<Integer>> graph) {
        for (int key : graph.keySet()) {
            Deque<Integer> deque = new ArrayDeque<>();
            deque.add(key);
            boolean[] visited = new boolean[N + 1];
            visited[key] = true;
            int count = -1;
            while (!deque.isEmpty()) {
                int cur = deque.poll();
                count++;

                if (count > limit) {
                    result++;
                    break;
                }

                for (int value : graph.getOrDefault(cur, new ArrayList<>())) {
                    if (visited[value]) continue;
                    deque.add(value);
                    visited[value] = true;
                }
            }
        }
    }
}
// 1 2 5
// 2 4
// 3 4
// 4
// 5

// 1
// 2 1
// 3
// 4 2 3
// 5 1