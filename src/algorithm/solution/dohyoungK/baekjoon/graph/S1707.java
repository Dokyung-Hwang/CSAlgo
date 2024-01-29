package algorithm.solution.dohyoungK.baekjoon.graph;

import algorithm.problem.baekjoon.graph.P1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1707 implements P1707 {
// TODO: *그래프가 이분 그래프인지 아닌지 판별하기
//  비연결 그래프도 생각하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            HashMap<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 0; i < E; i++) {
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
            int[] visited = new int[V + 1];

            boolean chk = true;
            LOOP:
            for (int i = 1; i < V; i++) {
                if (visited[i] != 0) continue;
                deque.add(i);
                visited[i] = 1;

                while (!deque.isEmpty()) {
                    int cur = deque.poll();
                    int curVisit = visited[cur];

                    for (int value : graph.getOrDefault(cur, new ArrayList<>())) {
                        if (visited[value] == 0) {
                            deque.add(value);
                            if (curVisit == 1) visited[value] = 2;
                            else visited[value] = 1;
                        } else {
                            if ((curVisit == 1 && visited[value] != 2) || (curVisit == 2 && visited[value] != 1)) {
                                chk = false;
                                break LOOP;
                            }
                        }
                    }
                }
            }

            if (chk) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
