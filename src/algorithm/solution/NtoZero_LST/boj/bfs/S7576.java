package algorithm.solution.NtoZero_LST.boj.bfs;

import algorithm.problem.baekjoon.bfs.P7576;

import java.util.*;
import java.io.*;

public class S7576 implements P7576 {
    /*
        문제 분석 : 인접 토마토의 영향을 받아 익게 되는 경우 그 최소 일수를 출력한다.
            - BFS : 인접, 최소 시일을 구하는 문제
                => 루트 노드를 기준으로 상하좌우 토마토를 방문하며, 0인 칸을 방문한다.
                    -1인 칸은 방문할 수 없으며, 익은 토마토는 그 즉시 또다른 전파를 시작한다.

        문제 풀이 :
            - 필요한 것
                1) dx, dy (상하좌우 탐색)
                2) 토마토 배열
                    + 방문 배열
                3) M, N (열, 행)
                4) 큐
                    - 큐 사이즈도 필요하다. (한 레벨(날짜)에서 어디까지 카운트 되는지)
                5) cnt (결과값)

     */
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] tomatoes;
    static boolean[][] visited;
    static int M, N; // 열, 행
    static int cnt; // 결과 소요일
    static Queue<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 열, y의 최대값<M
        N = Integer.parseInt(st.nextToken()); // 행, x의 최대값<N

        tomatoes = new int[N][M]; // 행렬
        visited = new boolean[N][M]; // 방문
        int rootX=0 , rootY = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if(tomatoes[i][j]==1) {
                    q.add(new int[]{i, j});
                    rootX = i; rootY = j;
                }
                if(tomatoes[i][j]!=0) visited[i][j]=true; // 방문할 필요X (-1, 2 등)
            }
        }

        bfs(rootX, rootY);

        // 모든 배열을 방문하지 않았으면 익는 것이 불가능 => -1 출력
        boolean impossible = false;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visited[i][j]) {
                    impossible = true;
                    break;
                }
            }
        }

        if(cnt==0) {
            cnt = 0; // 0일 때
        } else if(cnt!=0) {
            cnt = cnt-1; // 1부터 시작
        }
        if(impossible) cnt=-1;

        System.out.println(cnt);
    }

    static void bfs(int x, int y) {
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] elements = q.poll();
            int curX = elements[0];
            int curY = elements[1];

            for(int i=0; i<4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if((nextX>=0 && nextX<N) && (nextY>=0 && nextY<M) && tomatoes[nextX][nextY]==0) {
                    if(!visited[nextX][nextY]) {
                        q.add(new int[]{nextX, nextY});
                        // 이전 노드 +1로 distance 더하기
                        tomatoes[nextX][nextY] = tomatoes[curX][curY]+1;
                        if(tomatoes[nextX][nextY] > cnt) cnt = tomatoes[nextX][nextY];
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}