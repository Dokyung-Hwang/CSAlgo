package algorithm.solution.dohyoungK.baekjoon.bfs;

import algorithm.problem.baekjoon.bfs.P1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class S1697 implements P1697 {
// TODO:
//  수빈이가 동생이 있는 곳까지 가는 최단 시간 구하기

// TODO:
//  시작점에서 bfs로 도착점까지의 최단시간 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        boolean[] visited = new boolean[100001];

        Deque<Point> deque = new ArrayDeque<>();
        deque.add(new Point(start, 0));
        visited[start] = true;

        while (!deque.isEmpty()) {
            Point current = deque.pollFirst();
            visited[current.x] = true;

            if (current.x == end) {
                System.out.println(current.time);
                return;
            }

            for (int next : new int[]{current.x - 1, current.x + 1, current.x * 2}) {
                if (next < 0 || next > 100000) continue;
                if (visited[next]) continue;
                deque.add(new Point(next, current.time + 1));
            }
        }
    }

    public static class Point {
        int x;
        int time;

        public Point(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
