package algorithm.solution.smileDK.baejoon.dp;

import algorithm.problem.baekjoon.dp.P11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Todo
   * Input
   n(1 <= n <= 1,000)
   * Output
   * 2xn 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지 출력.
   * Table Definition
   d[i] = 2 x i 크기의 직사각형을 채우는 방법의 수
   * Recurrence
   d[n] = d[n-1] + d[n-2]
   */


public class S11726 implements P11726 {

    private static int[] d = new int[10001];
    private static final int mod = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        d[1] = 1;
        d[2] = 2;

        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % mod;
        }

        System.out.println(d[n]);
    }
}
