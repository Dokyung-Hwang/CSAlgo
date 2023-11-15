package algorithm.solution.smileDK.baejoon.backTracking;

import algorithm.problem.baekjoon.backTracking.P15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S15650 implements P15650 {
    private static int n;
    private static int m;
    private static int[] sequence;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sequence = new int[m];

        dfs(1, 0);

        System.out.println(sb);
    }

    // at: 현재 위치 -> 어디서 부터 시작하는 지
    public static void dfs(int at, int depth) {
        if (depth == m) {
            for (int value : sequence) {
                sb.append(value).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i <= n; i++) {
            sequence[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
