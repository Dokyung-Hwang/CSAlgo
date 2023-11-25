package algorithm.solution.dohyoungK.baekjoon.bfs;

import algorithm.problem.baekjoon.bfs.P2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class S2178 implements P2178 {
// TODO:
//  미로에서 최단거리 구하기

// TODO:
//  시작점에서 bfs로 도착점까지의 미로에서 최단거리 구하기

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            maze[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        Deque<Pair> deque = new ArrayDeque<>();
        boolean[][] visited  = new boolean[N][M];
        deque.add(new Pair(0, 0, 0));
        visited[0][0] = true;

        while (!deque.isEmpty()) {
            Pair current = deque.pollFirst();
            current.dist++;
            if (current.x == N - 1 && current.y == M - 1) {
                System.out.println(current.dist);
                return;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = current.x + dx[dir];
                int ny = current.y + dy[dir];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny] || maze[nx][ny] != 1) continue;
                visited[nx][ny] = true;
                deque.add(new Pair(nx, ny, current.dist));
            }
        }
    }

    public static class Pair {
        int x;
        int y;
        int dist;

        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
