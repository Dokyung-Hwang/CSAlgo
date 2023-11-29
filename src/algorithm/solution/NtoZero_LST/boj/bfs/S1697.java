package algorithm.solution.NtoZero_LST.boj.bfs;

import algorithm.problem.baekjoon.bfs.P1697;

import java.util.*;
import java.io.*;

public class S1697 implements P1697 {

    static int count; // 몇 번 이동 했는지
    static Queue<Integer> queue = new ArrayDeque<>();
    static int[] visited = new int[100000+1]; // int로 방문 배열을 두게 되면 depth(초)를 기록할 수 있다.
    static int N;
    static int K; // 목표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);
        System.out.println(count);
    }

    private static void bfs(int n) {
        queue.add(n);

        int idx = n;
        int x = 0;
        visited[idx] = 1; //int배열의 디폴트 값이 0이므로 시작점을 1로 구분

        while(!queue.isEmpty()) {
            x = queue.poll();

            if(x == K) {
                count = visited[x]-1;
            }
            // x-1
            if(x-1>=0 && visited[x-1] == 0) {
                visited[x-1] = visited[x]+1;
                queue.add(x-1);
            }
            // x+1
            if(x+1 <= 100000 && visited[x+1] == 0) {
                visited[x+1] = visited[x]+1;
                queue.add(x+1);
            }
            // 2x
            if(2*x <= 100000 && visited[2*x] == 0) {
                visited[2*x] = visited[x]+1;
                queue.add(2*x);
            }
        }
    }


}