package algorithm.solution.dohyoungK.baekjoon.bfs;

import algorithm.problem.baekjoon.bfs.P9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class S9466 implements P9466 {
//  TODO:
//   학생들이 원하는 팀원 목록을 입력받아
//   어느 팀에도 속하지 않는 학생 수 출력

//  TODO:
//   boolean[] visited, done을 사용해
//   사이클 찾기

    static int[] students;
    static boolean[] visited;
    static boolean[] done;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            students = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            visited = new boolean[n];
            done = new boolean[n];
            result = 0;

            for (int j = 0; j < n; j++) {
                if (!done[j]) {
                    dfs(students[j] - 1);
                }
            }

            System.out.println(n - result);
        }


    }

    public static void dfs(int current) {
        if (visited[current]) {
            done[current] = true;
            result++;
        } else visited[current] = true;

        int next = students[current] - 1;
        if (!done[next]) {
            dfs(next);
        }

        visited[current] = false;
        done[current] = true;
    }
}
