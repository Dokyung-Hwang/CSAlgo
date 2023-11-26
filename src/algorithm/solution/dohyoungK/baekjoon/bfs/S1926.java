package algorithm.solution.dohyoungK.baekjoon.bfs;

import algorithm.problem.baekjoon.bfs.P1926;
import algorithm.reference.graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class S1926 implements P1926 {
// TODO:
//  도화지에서 그림의 개수와 그림 중 넓이가 가장 넓은 것을 출력

// TODO:
//  이중 for문으로 그림의 시작점을 돌면서 bfs로 그림 넓이 구하기

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int width = Integer.parseInt(input[1]);
        int height = Integer.parseInt(input[0]);

        int[][] paper = new int[height][width];
        for (int i = 0; i < height; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        boolean[][] visited  = new boolean[height][width];
        int drawingNum = 0;
        int maxArea = 0;

        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++){
                if (visited[i][j] || paper[i][j] != 1) continue;
                int area = 0;
                Deque<Pair> deque = new ArrayDeque<>();
                deque.add(new Pair(i, j));
                visited[i][j] = true;
                drawingNum++;

                while (!deque.isEmpty()) {
                    Pair current = deque.pollFirst();
                    area++;

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = current.x + dx[dir];
                        int ny = current.y + dy[dir];
                        if (nx < 0 || nx >= height || ny < 0 || ny >= width) continue;
                        if (visited[nx][ny] || paper[nx][ny] != 1) continue;
                        visited[nx][ny] = true;
                        deque.add(new Pair(nx, ny));
                    }
                }
                maxArea = Math.max(maxArea, area);
            }
        }

        System.out.println(drawingNum);
        System.out.println(maxArea);
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
