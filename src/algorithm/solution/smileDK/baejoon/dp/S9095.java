package algorithm.solution.smileDK.baejoon.dp;

import algorithm.problem.baekjoon.dp.P9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Todo:
   * Operator
   d[i] = i를 1,2,3의 합으로 나타내는 방법의 수
   * Recurrence
   d[4] = ?
   1+1+1+(1) | 2+1+(1) | 1+2+(1) | 3+(1) => 3을 1,2,3의 합으로 나타내는 방법 + 1, d[3]
   1+1+(2) | 2+(2) => 2를 1,2,3의 합으로 나타내는 방법 + 2, d[2]
   1+(3) => 1을 1,2,3의 합으로 나타내는 방법 + 3, d[1]
   d[4] = d[1] + d[2] + d[3]
   d[i] = d[i-1] + d[i-2] + d[i-3]
 */

public class S9095 implements P9095 {
    private static int[] d = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for (int i = 4; i < 11; i++) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];
        }

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(d[n]).append("\n");
        }

        System.out.println(sb);
    }
}
