package algorithm.solution.dohyoungK.baekjoon.bfs;

import algorithm.problem.baekjoon.bfs.P7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class S7576 implements P7576 {
// TODO:
//  전체 박스에서 토마토가 전부 익을 때까지의 최소 일수 구하기

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int width = Integer.parseInt(input[0]);
        int height = Integer.parseInt(input[1]);

        int[][] box = new int[height][width];
        int[][] dist = new int[height][width];
        for (int i = 0; i < height; i++) {
            box[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        Deque<Pair> deque = new ArrayDeque<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (box[i][j] == 1) {
                    deque.add(new Pair(i, j));
                }
                dist[i][j] = box[i][j];
            }
        }

        while (!deque.isEmpty()) {
            Pair current = deque.pollFirst();

            for (int dir = 0; dir < 4; dir++) {
                int nx = current.x + dx[dir];
                int ny = current.y + dy[dir];
                if (nx < 0 || nx >= height || ny < 0 || ny >= width) continue;
                if (dist[nx][ny] > 0 || box[nx][ny] == -1) continue;
                dist[nx][ny] = dist[current.x][current.y] + 1;
                deque.add(new Pair(nx, ny));
            }
        }

        int maxDist = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (dist[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                maxDist = Math.max(maxDist, dist[i][j]);
            }
        }

        System.out.println(maxDist - 1);
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
