package algorithm.solution.dohyoungK.baekjoon.graph;

import algorithm.problem.baekjoon.graph.P1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1043 implements P1043 {
// TODO: 거짓말쟁이로 알려지지 않으면서
//  과장된 이야기를 할 수 있는 파티 개수의 최댓값 찾기

    static int N;
    static Set<Integer> truthSet; // 중복 방지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        if (T == 0) {
            System.out.println(M);
            return;
        }

        truthSet = new HashSet<>();
        for (int i = 0; i < T; i++) {
            truthSet.add(Integer.parseInt(st.nextToken()));
        }

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < n; j++) party.add(Integer.parseInt(st.nextToken()));
            parties.add(party);

            for (int j = 0; j < n; j++) {
                int key = party.get(j);
                List<Integer> value = graph.getOrDefault(key, new ArrayList<>());
                value.addAll(party.subList(0, j));
                value.addAll(party.subList(j + 1, party.size()));
                graph.put(key, value);
            }
        }

        bfs(graph); // 같이 파티를 가는 사람들을 truthSet에 추가

        int result = 0;
        for (List<Integer> party : parties) {
            boolean chk = true;
            for (int person : party) {
                if (truthSet.contains(person)) {
                    chk = false;
                    break;
                }
            }

            if (chk) result++;
        }

        System.out.println(result);
    }

    public static void bfs(HashMap<Integer, List<Integer>> graph) {
        Set<Integer> newSet = new HashSet<>();

        for (int key : truthSet) {
            Deque<Integer> deque = new ArrayDeque<>();
            deque.add(key);
            boolean[] visited = new boolean[N + 1];
            visited[key] = true;
            while (!deque.isEmpty()) {
                int cur = deque.poll();
                newSet.add(cur);

                for (int value : graph.getOrDefault(cur, new ArrayList<>())) {
                    if (visited[value]) continue;
                    deque.add(value);
                    visited[value] = true;
                }
            }
        }
        truthSet.addAll(newSet);
    }
}
