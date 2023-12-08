package algorithm.solution.dohyoungK.baekjoon.hash;

import algorithm.problem.baekjoon.hash.P20166;

import java.io.*;
import java.util.*;

public class S20166 implements P20166 {
// TODO: *
//  문자들이 적힌 N X M 격자에서
//  신이 좋아하는 문자열을 만들수있는 경우의 수 출력
//  (상하좌우, 대각선 이동가능 + 상하좌우 대각선 범위가 환형으로 이어짐)
//  (신이 좋아하는 문자열은 중복 가능)

// TODO:
//  bfs로 상하좌우 대각선 돌면서 문자열을 늘리고
//  신이 좋아하는 문자열이라면 hashmap value + 1

    static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        // 신이 좋아하는 문자열이 몇번 등장하는 지 저장할 hm
        HashMap<String, Integer> hm = new LinkedHashMap<>();
        // bfs 종료 조건용
        int maxLength = 0;
        // hashmap에만 저장하면 중복된 문자열이 하나만 저장되기 때문에 결과 출력용 리스트
        List<String> likeStrs = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            String str = br.readLine();
            hm.put(str, 0);
            likeStrs.add(str);
            maxLength = Math.max(maxLength, str.length());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Deque<Point> deque = new ArrayDeque<>();
                deque.add(new Point(i, j, String.valueOf(grid[i][j])));

                while (!deque.isEmpty()) {
                    Point current = deque.pollFirst();

                    int count = hm.getOrDefault(current.word, -1);
                    if (count != -1) {
                        hm.put(current.word, count + 1);
                    }

                    if (current.word.length() == maxLength) continue;

                    for (int k = 0; k < 8; k++) {
                        int nx = current.x + dx[k];
                        int ny = current.y + dy[k];

                        // 환형 변환
                        if (nx == -1) nx = N - 1;
                        if (nx == N) nx = 0;
                        if (ny == -1) ny = M - 1;
                        if (ny == M) ny = 0;

                        deque.add(new Point(nx, ny, current.word + grid[nx][ny]));
                    }
                }
            }
        }

        likeStrs.forEach(str -> {
            try {
                bw.write(hm.get(str) + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bw.flush();
        bw.close();
    }

    public static class Point {
        int x;
        int y;
        String word;

        public Point(int x, int y, String word) {
            this.x = x;
            this.y = y;
            this.word = word;
        }
    }
}
