package algorithm.solution.smileDK.baejoon.dp;

import algorithm.problem.baekjoon.dp.P1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Todo
    RGB(빨강,초록,파랑) n(집)
    * Rule
    1. 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
    2. n번 집의 색은 n-1번 집의 색과 같지 않아야 한다.
    3. i(2<=i<=n-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
    * Input
    첫 째줄에 집의 수 n, 둘째 줄부터 n개의 줄 까지 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어짐
    집을 칠하는 비용은 1,000 보다 작거나 같은 자연수
    * Output
    모든 집을 칠하는 비용의 최솟값
    * Table Definition
    d[i][0] = i번째 집까지 칠할 때 비용의 최솟값, 단 i번째 집은 빨강
    d[i][1] = i번째 집까지 칠할 때 비용의 최솟값, 단 i번째 집은 초록
    d[i][2] = i번째 집까지 칠할 때 비용의 최솟값, 단 i번째 집은 파랑
    * Recurrence
    d[k][0] = min(d[k-1][1], d[k-1][2]) + R[k]
    d[k][1] = min(d[k-1][0], d[k-1][2]) + G[k]
    d[k][2] = min(d[k-1][0], d[k-1][1]) + B[k]
*/

public class S1149 implements P1149 {

    private static int[][] d = new int[1001][3];
    private static int[] r = new int[1001];
    private static int[] g = new int[1001];
    private static int[] b = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        d[1][0] = r[1];
        d[1][1] = g[1];
        d[1][2] = b[1];

        for (int i = 2; i <= n; i++) {
            d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + r[i];
            d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + g[i];
            d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + b[i];
        }

        int min = Math.min(Math.min(d[n][0], d[n][1]), d[n][2]);
        System.out.println(min);
    }
}
