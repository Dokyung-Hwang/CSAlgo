package algorithm.solution.NtoZero_LST.boj.bfs;

import algorithm.problem.baekjoon.bfs.P2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://what-am-i.tistory.com/77 (동남서북)

public class S2178 implements P2178 {
    /*
        최단 거리를 구하는 문제 -> bfs
     */
    // 상하좌우 이동 -> 남 동 북 서 (위쪽으로 가는 것은 배열상으로 아래쪽으로 가는 것이다.)
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] A; // 인접 행렬 이차원 배열
    static boolean[][] visited;
    static Queue<int[]> queue = new ArrayDeque<>(); //x, y의 좌표값을 기록할 수 있어야 함.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        A = new int[N+1][E+1];
        visited = new boolean[N+1][E+1];
        int result = 1;

        // 인접 행렬 그리기
        for(int i=1; i<=N; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j=1; j<=E; j++) {
                A[i][j] = chars[j-1]-'0';
            }
        }

        bfs(1,1);
        System.out.println(A[N][E]);
    }

    static void bfs(int i, int j) {

        queue.add(new int[]{i, j});
        //bfs의 모든 요소를 탐색할 때까지
        while(!queue.isEmpty()) {
            int[] cursor = queue.poll();
            visited[i][j] = true;
            for(int k=0; k<4; k++) { //상하좌우 탐색
                // 한 점은 그대로 있고 한 점은 이동 한다. (dx배열의 k인덱스 요소)
                int x = cursor[0] + dx[k];
                int y = cursor[1] + dy[k];

                // validation
                if(x >=0 && y>=0 && x < A.length && y < A[1].length) { // 배열 인덱스 조건
                    if(A[x][y]!=0&&!visited[x][y]) { // 0이어서 갈 수 없거나 기방문한 곳이면 안됨
                        visited[x][y] = true;
                        //현재 이차원 배열은 이전 depth에서 +1 추가
                        A[x][y] = A[cursor[0]][cursor[1]] + 1; // 이전 위치 인덱스에 depth+1
                        // 이동한 위치의 x,y를 queue의 요소로 포함
                        queue.add(new int[] {x,y});
                    }
                }
            }
        }
    }
}