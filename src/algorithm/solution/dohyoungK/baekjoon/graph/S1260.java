package algorithm.solution.dohyoungK.baekjoon.graph;

import algorithm.problem.baekjoon.graph.P1260;

import java.io.*;
import java.util.*;

public class S1260 implements P1260 {
// TODO: 그래프를 DFS와 BFS로 탐색한 결과 출력하기
// TODO: 그래프 연결된 노드 리스트 정렬한 후 탐색

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int start;
    static HashMap<Integer, List<Integer>> graph = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

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

        dfs();
        bfs();
        bw.flush();
        bw.close();
    }

    public static void dfs() throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        boolean[] visited = new boolean[N + 1];
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            if (visited[cur]) continue;
            visited[cur] = true;
            bw.write(cur + " ");

            List<Integer> values = new ArrayList<>(graph.getOrDefault(cur, new ArrayList<>()));
            Collections.sort(values);
            Collections.reverse(values);
            for (int value : values) {
                if (visited[value]) continue;
                deque.addFirst(value);
            }
        }

        bw.write("\n");
    }

    public static void bfs() throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            bw.write(cur + " ");

            List<Integer> values = graph.getOrDefault(cur, new ArrayList<>());
            Collections.sort(values);
            for (int value : values) {
                if (visited[value]) continue;
                deque.add(value);
                visited[value] = true;
            }
        }
    }
}
