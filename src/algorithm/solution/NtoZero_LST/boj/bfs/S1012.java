package algorithm.solution.NtoZero_LST.boj.bfs;

import algorithm.problem.baekjoon.bfs.P1012;

import java.util.*;
import java.io.*;

public class S1012 implements P1012 {
    /*
        문제 분석 : 상하좌우 이동을 통해 연결요소의 개수를 탐색하는 문제
            - 지렁이 마리 수 = 연결 요소 개수
            - '상하좌우'의 이동 -> 너비 우선탐색(bfs)

        의문점.
            - 연결 요소에서 가로, 세로를 깊게 생각할 필요가 있나?
                어차피 이차원 배열을 뒤집으면 똑같지 않나?
     */
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = 0;
    static int[][] A;
    static boolean[][] visited;
    static Queue<int[]> Q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 각 테스트 케이스 '열' 개수
            int N = Integer.parseInt(st.nextToken()); // 각 테스트 케이스 '행' 개수
            int K = Integer.parseInt(st.nextToken()); // 배추가 심어진 수의 개수

            //가로, 세로 개수 신경써서 뒤바꾸기
            A = new int[M][N];
            visited = new boolean[M][N];

            // 배추 초기화
            for(int j=0; j<K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // x가 세로축 (이차원 배열상 행)
                int y = Integer.parseInt(st.nextToken()); // y가 가로축 (이차원 배열상 열)
                A[x][y] = 1; //배열상 y가 가로(열), x가 세로(행)
            }

            //전체 범위를 탐색해야 한다.
            for(int j=0; j<M; j++) {
                for(int l=0; l<N; l++) {
                    if(A[j][l] == 1 && !visited[j][l]) { //시작할 루트 노드의 유효성 검사
                        bfs(j, l);
                        result++;
                    }
                }
            }
            bw.write(String.valueOf(result)+"\n");
            result = 0; // result 초기화
        }
        bw.close();
    }
    public static void bfs(int i, int j) {
        if(visited[i][j]) return;
        visited[i][j] = true;

        Q.add(new int[]{i, j});

        while(!Q.isEmpty()) {
            int[] arr = Q.poll();
            int a = arr[0];
            int b = arr[1];
            for(int k=0; k<4; k++) {
                int x = a + dx[k];
                int y = b + dy[k];

                // x가 세로 y가 가로 조건
                if((x>=0&&x<A.length) && (y>=0&&y<A[0].length) && A[x][y]!=0) {
                    if(!visited[x][y]) {
                        Q.add(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
        }
    }
}