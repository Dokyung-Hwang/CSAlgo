package algorithm.solution.smileDK.baejoon.dp;

import algorithm.problem.baekjoon.dp.P2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Todo
    이친수 Rule
    1. 0으로 시작 x
    2. 1 두 번 연속 x
    * Table Definition
    D[i] = i자리 이친수 개수
    * Recurrence
    D[1] = 1 -> 1
    D[2] = 10 -> 1
    D[3] = 100, 101 -> 2 => D[1] + 1
    D[4] = 1000, 1001, 1010 -> 3 => D[1] + D[2] + 1
    D[5] = 10000, 10001, 10010, 10100, 10101 -> 5 => D[1] + D[2] + D[3] + 1
    D[6] = 100000, 100001, 100010, 100100, 100101, 101000, 101001, 101010 -> 8 => D[1] + D[2] + D[3] + D[4] + 1
    D[i] = D[1] + D[2] + ... + D[i-2] + 1
    * 오답 노트
    배열의 크기를 할당할 때 n+1로 하면 dp[2]일 때 OutOfRange를 만날 수 있다.
    따라서, 배열의 크기를 문제의 입력 크기 만큼 할당하거나, 배열의 크기를 벗어난 요소가 있는 지 확인해야 한다.
* */


public class S2193 implements P2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 2];

        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for(int j = 1; j <= i - 2; j++) {
                dp[i] += dp[j];
            }
            dp[i] += 1;
        }

        System.out.println(dp[n]);
    }
}
