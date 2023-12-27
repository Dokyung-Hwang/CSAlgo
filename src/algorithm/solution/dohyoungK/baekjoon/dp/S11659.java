package algorithm.solution.dohyoungK.baekjoon.dp;

import algorithm.problem.baekjoon.dp.P11659;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S11659 implements P11659 {
//  TODO:
//   수 N개가 주어졌을 때
//   i번째부터 j번째까지 합을 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[100001];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }

        for (int k = 0; k < M; k++) {
            String[] input = br.readLine().split(" ");
            int i = Integer.parseInt(input[0]);
            int j = Integer.parseInt(input[1]);
            bw.write(dp[j] - dp[i - 1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
