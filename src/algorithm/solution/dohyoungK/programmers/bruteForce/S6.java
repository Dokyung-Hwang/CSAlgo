package algorithm.solution.dohyoungK.programmers.bruteForce;

import algorithm.problem.programmers.bruteForce.P6;

import java.util.*;

public class S6 implements P6 {
    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}}));
    }

// TODO:
//  송전탑 개수와 연결된 전선을 입력으로 받아
//  전선 하나를 끊었을 때 두 전력망의 송전탑 개수를
//  최대한 비슷하게 맞출 수 있는 경우의 송전탑 차이를 리턴

// TODO:
//  연결된 전선들을 그래프로 만들고
//  연결된 전선 배열을 돌면서 [송전탑1, 송전탑2] 원소마다 연결을 끊어보면서
//  송전탑1로부터 시작되는 전력망의 총 송전탑 개수,
//  송전탑2로부터 시작되는 전력망의 총 송전탑 개수 비교

    static boolean[] visited;
    static int cnt;

    public static int solution(int n, int[][] wires) {
        int result = 100;

        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        for (int[] wire : wires) {
            HashSet<Integer> value = hm.getOrDefault(wire[0], new HashSet<>());
            value.add(wire[1]);
            hm.put(wire[0], value);

            value = hm.getOrDefault(wire[1], new HashSet<>());
            value.add(wire[0]);
            hm.put(wire[1], value);
        }

        for (int[] wire : wires) {
            hm.get(wire[0]).remove(wire[1]);
            hm.get(wire[1]).remove(wire[0]);

            result = Math.min(result, Math.abs(getConnectionNum(n, wire[0], hm) - getConnectionNum(n, wire[1], hm)));

            hm.get(wire[0]).add(wire[1]);
            hm.get(wire[1]).add(wire[0]);
        }

        return result;
    }

    public static int getConnectionNum(int n, int start, HashMap<Integer, HashSet<Integer>> hm) {
        visited = new boolean[n];
        cnt = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        while (!deque.isEmpty()) {
            int wire = deque.pollFirst();
            visited[wire - 1] = true;
            cnt++;
            for (int w : hm.get(wire)) {
                if (!visited[w - 1]) {
                    deque.add(w);
                }
            }
        }

        return cnt;
    }
}
