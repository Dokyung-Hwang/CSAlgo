package algorithm.solution.dohyoungK.baekjoon.bfs;

import algorithm.problem.baekjoon.bfs.P5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class S5427 implements P5427 {
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
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            C = Integer.parseInt(input[0]);
            R = Integer.parseInt(input[1]);
            maze = new String[R][C];
            for (int j = 0; j < R; j++) {
                maze[j] = br.readLine().split("");
            }

            Deque<Point> deque = new ArrayDeque<>();
            boolean[][] visited = new boolean[R][C];
            boolean[][] fireVisited = new boolean[R][C];
            Point start = new Point(0, 0, 0);
            Deque<Point> fires = new ArrayDeque<>();
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (maze[j][k].equals("@")) {
                        start = new Point(j, k, 0);
                        visited[j][k] = true;
                    } else if (maze[j][k].equals("*")) {
                        fires.add(new Point(j, k, 0));
                    }
                }
            }

            deque.add(start);
            int cnt = 0;
            boolean chk = true;
            while (!deque.isEmpty()) {
                Point current = deque.pollFirst();
                if (cnt == current.time) {
                    fires = moveFire(fires, fireVisited);
                    cnt++;
                }

                if (current.x == 0 ||current.x == R - 1 || current.y == 0 || current.y == C - 1) {
                    System.out.println(current.time + 1);
                    chk = false;
                    break;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = current.x + dx[j];
                    int ny = current.y + dy[j];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if (visited[nx][ny] || maze[nx][ny].equals("#") || maze[nx][ny].equals("*")) continue;
                    visited[nx][ny] = true;
                    deque.add(new Point(nx, ny, current.time + 1));
                }
            }

            if (chk) System.out.println("IMPOSSIBLE");
        }
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
                maze[nx][ny] = "*";
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
