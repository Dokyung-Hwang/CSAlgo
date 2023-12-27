package algorithm.solution.dohyoungK.baekjoon.bfs;

import algorithm.problem.baekjoon.bfs.P4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class S4179 implements P4179 {

//    # : 벽
//    . : 지나갈 수 있는 공간
//    J : 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
//    F : 불이 난 공간
// TODO:
//  미로를 탈출할 수 있는 경우 가장 빠른 탈출 시간,
//  탈출 불가한 경우 IMPOSSIBLE 출력

// TODO:
//  시작점과 불난 자리를 찾아서
//  불을 먼저 bfs로 번지게 한 후,
//  나를 bfs로 이동
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int R;
    static int C;
    static String[][] maze;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        maze = new String[R][C];
        for (int i = 0; i < R; i++) {
            maze[i] = br.readLine().split("");
        }

        Deque<Point> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];
        boolean[][] fireVisited = new boolean[R][C];
        Point start = new Point(0, 0, 0);
        Deque<Point> fires = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (maze[i][j].equals("J")) {
                    start = new Point(i, j, 0);
                    visited[i][j] = true;
                } else if (maze[i][j].equals("F")) {
                    fires.add(new Point(i, j, 0));
                }
            }
        }

        deque.add(start);
        int cnt = 0;
        while (!deque.isEmpty()) {
            Point current = deque.pollFirst();
            if (cnt == current.time) {
                fires = moveFire(fires, fireVisited);
                cnt++;
            }

            if (current.x ==0 ||current.x == R - 1 || current.y == 0 || current.y == C - 1) {
                System.out.println(current.time + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (visited[nx][ny] || maze[nx][ny].equals("#") || maze[nx][ny].equals("F")) continue;
                visited[nx][ny] = true;
                deque.add(new Point(nx, ny, current.time + 1));
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    private static Deque<Point> moveFire(Deque<Point> fires, boolean[][] fireVisited) {
        Deque<Point> nextFire = new ArrayDeque<>();

        while (!fires.isEmpty()) {
            Point current = fires.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (fireVisited[nx][ny] || maze[nx][ny].equals("#")) continue;
                fireVisited[nx][ny] = true;
                maze[nx][ny] = "F";
                nextFire.add(new Point(nx, ny, 0));
            }
        }

        return nextFire;
    }

    public static class Point {
        int x;
        int y;
        int time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
