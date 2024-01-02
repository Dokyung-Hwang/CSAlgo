package algorithm.solution.smileDK.baejoon.dp;

import algorithm.problem.baekjoon.dp.P9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S9461 implements P9461 {
    private static final Long[] sequence = new Long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sequence[0] = 0L;
        sequence[1] = 1L;
        sequence[2] = 1L;
        sequence[3] = 1L;

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            sb.append(padovan(Integer.parseInt(br.readLine()))).append('\n');
        }
        System.out.println(sb);
    }

    public static long padovan(int n) {
        if(sequence[n] == null) {
            sequence[n] = padovan(n - 2) + padovan(n - 3);
        }
        return sequence[n];
    }
}
