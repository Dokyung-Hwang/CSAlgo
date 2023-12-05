package algorithm.solution.dohyoungK.baekjoon.backTracking;

import algorithm.problem.baekjoon.backTracking.P1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1941 implements P1941 {
// Todo:
//  5x5 반에서 7자리의 조합 중
//  S가 4개 이상인 경우 찾기

// Todo:
//  bfs로 자리 조합을 구하려 했으나 상하좌우를 다 살펴보면 시간초과
//  + bfs로는 모든 조합을 구하기 어려움

//  x x x x x  (이런 모양의 자리)
//      x
//      x

// Todo:
//  따라서 조합으로 총 25개의 자리 중 7개씩을 뽑고
//  그렇게 구한 자리들을 bfs로 상하좌우 연결되어있는지 확인
//  + S가 4개이상인지 확인

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static List<int[]> combinations = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] classroom = new String[5][5];
        int result = 0;

        for (int i = 0; i < 5; i++) {
            classroom[i] = br.readLine().split("");
        }

        int[] comb = new int[7];
        boolean[] visited = new boolean[25];
        combination(comb, visited, 0, 0);

        for (int[] cb : combinations) {
            Deque<Integer> deque = new ArrayDeque<>();
            deque.add(cb[0]);
            int numS = 0;
            int cnt = 1;
            boolean[][] selected = new boolean[5][5];
            for (int num : cb) {
                selected[num / 5][num % 5] = true;
            }
            if (classroom[cb[0] / 5][cb[0] % 5].equals("S")) numS++;
            selected[cb[0] / 5][cb[0] % 5] = false;

            while (!deque.isEmpty()) {
                int current = deque.pollFirst();

                for (int i = 0; i < 4; i++) {
                    int nx = current / 5 + dx[i];
                    int ny = current % 5 + dy[i];
                    if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;

                    if (selected[nx][ny]) {
                        if (classroom[nx][ny].equals("S")) numS++;
                        selected[nx][ny] = false;
                        deque.add(nx * 5 + ny);
                        cnt++;
                    }
                }
            }

            if (cnt == 7 && numS >= 4) {
                result++;
            }
        }

        System.out.println(result);
    }

    // 25개 자리중 조합 구하기
    public static void combination(int[] comb, boolean[] visited, int start, int index) {
        if (index == 7) {
            combinations.add(Arrays.stream(comb).toArray());
            return;
        }

        for (int i = start; i < 25; i++) {
            visited[i] = true;
            comb[index] = i;
            combination(comb, visited, i + 1, index + 1);
            visited[i] = false;
        }
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
