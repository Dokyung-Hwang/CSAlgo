package algorithm.solution.smileDK.baejoon.greedy;

import algorithm.problem.baekjoon.greedy.P11501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S11501 implements P11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 주가를 담을 배열
        int[] stock;

        // 모든 테스트 케이스를 진행
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long maximum = 0;

            st = new StringTokenizer(br.readLine());
            stock = new int[n];

            for (int j = 0; j < n; j++) {
                stock[j] = Integer.parseInt(st.nextToken());
            }

            int temp = stock[n - 1];

            for (int k = n - 2; k >= 0; k--) {
                if (stock[k] <= temp) {
                    maximum += temp - stock[k];
                }
                else
                    temp = stock[k];
            }

            sb.append(maximum).append("\n");
        }

        System.out.println(sb);
    }
}
