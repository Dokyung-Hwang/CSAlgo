package algorithm.solution.smileDK.baejoon.dp;

import algorithm.problem.baekjoon.dp.P1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Todo:
   Operator
   1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
   2. X가 2로 나누어 떨어지면, 2로 나눈다.
   3. 1을 뺀다.
   * Recurrence
   d[k] = ?
   d[k] = d[k/3] + 1 (3으로 나누기)
   d[k] = d[k/2] + 1 (2로 나누기)
   d[k] = d[k-1] + 1 (1로 빼기)
   d[k] = min(d[k/3] + 1 | d[k/2] + 1 | d[k-1] + 1)
   */


public class S1463 implements P1463 {

    private static int[] d = new int[10000001];
    private static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());

        d[1] = 0;
        for (int i = 2; i <= x; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 2 == 0) d[i] = Math.min(d[i], d[i/2] + 1);
            if (i % 3 == 0) d[i] = Math.min(d[i], d[i/3] + 1);
        }

        System.out.println(d[x]);
    }
}
