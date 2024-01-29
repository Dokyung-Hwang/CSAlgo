package algorithm.solution.dohyoungK.baekjoon.graph;

import algorithm.problem.baekjoon.graph.P2660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2660 implements P2660 {
// TODO: 모임의 회원들과의 관계로 점수가 측정되고
//  그 중 점수가 최소인 사람과 최소 점수 찾기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (u == -1) break;

            List<Integer> uValue = graph.getOrDefault(u, new ArrayList<>());
            List<Integer> vValue = graph.getOrDefault(v, new ArrayList<>());
            uValue.add(v);
            vValue.add(u);
            graph.put(u, uValue);
            graph.put(v, vValue);
        }

        int[][] result = new int[n][2];
        for (int i = 1; i <= n; i++) {
            Deque<Pair> deque = new ArrayDeque<>();
            deque.add(new Pair(i, 0));
            int[] visited = new int[n + 1];
            visited[i] = 1;

            int maxRoute = 0;
            while (!deque.isEmpty()) {
                Pair cur = deque.poll();

                for (int value : graph.getOrDefault(cur.person, new ArrayList<>())) {
                    if (visited[value] != 0) continue;
                    deque.add(new Pair(value, cur.route + 1));
                    visited[value] = cur.route + 1;
                    maxRoute = Math.max(maxRoute, cur.route + 1);
                }
            }

            result[i - 1] = new int[]{maxRoute, i};
        }

        Arrays.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) return -1;
                if (o1[0] > o2[0]) return 1;
                return o1[1] - o2[1];
            }
        });

        int minScore = result[0][0];
        int count = 0;
        List<Integer> persons = new ArrayList<>();
        for (int[] arr : result) {
            if (minScore == arr[0]) {
                count++;
                persons.add(arr[1]);
            }
        }

        System.out.println(minScore + " " + count);
        persons.forEach(e -> System.out.printf(e + " "));
    }

    public static class Pair {
        int person;
        int route;

        public Pair(int person, int route) {
            this.person = person;
            this.route = route;
        }
    }
}
