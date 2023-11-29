package algorithm.solution.smileDK.baejoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2178 {

    static int[][] maze;
    static int[][] distance;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++)
                maze[i][j] = line.charAt(j) - '0';
        }

        bfs();

        System.out.println(distance[n - 1][m - 1]);
    }

    public static void bfs() {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        distance[0][0] = 1;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = current.x + dx[dir];
                int ny = current.y + dy[dir];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == 1 && distance[nx][ny] == 0) {
                    queue.add(new Pair(nx, ny));
                    distance[nx][ny] = distance[current.x][current.y] + 1;
                }
            }
        }
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
