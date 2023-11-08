package algorithm.solution.smileDK.baejoon.recursion;

import algorithm.problem.baekjoon.recursion.P1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1074 implements P1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(func(n, r, c));
    }

    public static int func(int n, int r, int c) {
        if (n == 0) return 0;

        int half = 1 << (n - 1);

        // (2, 1, 3, 4) 분면
        if (r < half && c < half) return func(n - 1, r, c);
        if (r < half && c >= half) return half * half + func(n - 1, r, c - half);
        if (r >= half && c < half) return 2 * half * half + func(n - 1, r - half, c);
        return 3 * half * half + func(n - 1, r - half, c - half);
    }

}
