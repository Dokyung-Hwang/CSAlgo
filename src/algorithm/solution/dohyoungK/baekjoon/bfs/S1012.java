package algorithm.solution.dohyoungK.baekjoon.bfs;

import algorithm.problem.baekjoon.bfs.P1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class S1012 implements P1012 {
// TODO:
//  배추 밭에서 해충을 막기위한 최소 지렁이 수 구하기

// TODO:
//  전체 밭에서 bfs로 배추 구역 구하기

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            int width = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);
            int num = Integer.parseInt(input[2]);
            int result = 0;
            int[][] field = new int[height][width];
            boolean[][] visited = new boolean[height][width];

            for (int i = 0; i < num; i++) {
                String[] points = br.readLine().split(" ");
                field[Integer.parseInt(points[1])][Integer.parseInt(points[0])] = 1;
            }

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (field[i][j] != 1 || visited[i][j]) continue;
                    Deque<Point> deque = new ArrayDeque<>();
                    deque.add(new Point(i, j));
                    visited[i][j] = true;
                    result++;

                    while (!deque.isEmpty()) {
                        Point current = deque.pollFirst();

                        for (int k = 0; k < 4; k++) {
                            int nx = current.x + dx[k];
                            int ny = current.y + dy[k];
                            if (nx < 0 || nx >= height || ny < 0 || ny >= width) continue;
                            if (visited[nx][ny] || field[nx][ny] != 1) continue;
                            visited[nx][ny] = true;
                            deque.add(new Point(nx, ny));
                        }
                    }
                }
            }

            System.out.println(result);
        }
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
