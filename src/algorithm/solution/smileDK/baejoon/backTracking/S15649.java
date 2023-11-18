package algorithm.solution.smileDK.baejoon.backTracking;

import algorithm.problem.baekjoon.backTracking.P15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ-15649: N과 M(1)
// Q: 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
// C: 1s, 512MB
// input: N, M(1 ≤ M ≤ N ≤ 8)
// output: 한 줄에 하나씩 문제의 조건을 만족하는 수열 출력, 중복되는 수열을 여러 번 출력 x, 각 수열은 공백으로 구분해서 출력, 수열은 사전 순으로 증가하는 순서로 출력

// S: 중복되는 수를 제외한 모든 경우의 수를 탐색

public class S15649 implements P15649 {

    private static int n;
    private static int m;
    private static int[] sequence;
    private static boolean[] visited;
    private static final StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sequence = new int[m];
        visited = new boolean[n];

        dfs(0);
        System.out.println(sb);

    }


    public static void dfs(int depth) {

        // Base Condition
        if (depth == m) {
            for (int value : sequence) {
                sb.append(value).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }
        }

    }
}
