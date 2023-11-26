package algorithm.solution.dohyoungK.baekjoon.bfs;

import algorithm.problem.baekjoon.bfs.P7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class S7562 implements P7562 {
// TODO:
//  시작점에서 도착점까지의 나이트 최소 이동 횟수 구하기

    static int[] dx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] start = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] end = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            boolean[][] visited = new boolean[N][N];

            Deque<Point> deque = new ArrayDeque<>();
            deque.add(new Point(start[0], start[1], 0));
            visited[start[0]][start[1]] = true;

            while (!deque.isEmpty()) {
                Point current = deque.pollFirst();

                if (current.x == end[0] && current.y == end[1]) {
                    System.out.println(current.dist);
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    deque.add(new Point(nx, ny, current.dist + 1));
                }
            }
        }
    }

    public static class Point {
        int x;
        int y;
        int dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
