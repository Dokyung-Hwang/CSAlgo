package algorithm.solution.dohyoungK.baekjoon.bfs;

import algorithm.problem.baekjoon.bfs.P10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class S10026 implements P10026 {
// TODO:
//  적록색약(RED와 GREEN의 차이없음)인 사람이 봤을 때의 구역 개수 출력

// TODO:
//  색약이 아닌 일반인 기준으로 bfs 한번
//  초록, 빨강의 구역을 통일해서 색약용 bfs 한번

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int N;
    static String[][] colors;
    static Deque<Pair> deque = new ArrayDeque<>();
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        colors = new String[N][N];

        for (int i = 0; i < N; i++) {
            colors[i] = br.readLine().split("");
        }

        visited = new boolean[N][N];
        int result = bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (colors[i][j].equals("G")) {
                    colors[i][j] = "R";
                }
            }
        }
        visited = new boolean[N][N];
        int minResult = bfs(); // 색약 결과

        System.out.println(result + " " + minResult);
    }

    public static int bfs() {
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;
                deque.add(new Pair(i, j));
                result++;

                while (!deque.isEmpty()) {
                    Pair current = deque.pollFirst();
                    String curColor = colors[current.x][current.y];

                    for (int k = 0; k < 4; k++) {
                        int nx = current.x + dx[k];
                        int ny = current.y + dy[k];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if (visited[nx][ny]) continue;
                        if (!curColor.equals(colors[nx][ny])) continue; // 다음 갈 곳의 컬러가 같지 않다면 다른 영역

                        visited[nx][ny] = true;
                        deque.add(new Pair(nx, ny));
                    }
                }
            }
        }

        return result;
    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
