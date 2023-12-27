package algorithm.solution.dohyoungK.baekjoon.bfs;

import algorithm.problem.baekjoon.bfs.P2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class S2206 implements P2206 {
// TODO:
//  N X M 맵에서 시작지점에서 도착지점까지 최단경로 출력
//  (벽을 부수고 최단 거리가 가능하다면 한개까지 부수기 가능)

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] maze = new int[N][M];
        boolean[][][] visited = new boolean[2][N][M]; // 벽을 부수지 않았을 때, 벽을 부쉈을 때 visited
        for (int i = 0; i < N; i++) {
            maze[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        Deque<Point> deque = new ArrayDeque<>();
        deque.add(new Point(0, 0, 1L, false));
        visited[0][0][0] = true;
        while (!deque.isEmpty()) {
            Point current = deque.pollFirst();

            if (current.x == N - 1 && current.y == M - 1) {
                System.out.println(current.dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (maze[nx][ny] == 0) {
                    if (!current.breakWall) {
                        if (visited[0][nx][ny]) continue;
                        visited[0][nx][ny] = true;
                        deque.add(new Point(nx, ny, current.dist + 1, false));
                    } else {
                        if (visited[1][nx][ny]) continue;
                        visited[1][nx][ny] = true;
                        deque.add(new Point(nx, ny, current.dist + 1, true));
                    }
                } else {
                    if (!current.breakWall) {
                        visited[1][nx][ny] = true;
                        deque.add(new Point(nx, ny, current.dist + 1, true));
                    }
                }
            }
        }

        System.out.println(-1);
    }

    public static class Point {
        int x;
        int y;
        long dist;
        boolean breakWall; // 벽을 부순적이 있는 지

        public Point(int x, int y, long dist, boolean breakWall) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.breakWall = breakWall;
        }
    }
}
