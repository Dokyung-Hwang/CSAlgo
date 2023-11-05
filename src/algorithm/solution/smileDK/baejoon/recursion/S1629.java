package algorithm.solution.smileDK.baejoon.recursion;

import algorithm.problem.baekjoon.recursion.P1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1629 implements P1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B, C));
    }


    public static long pow(int A, int B, int C) {
        // base case
        if (B == 0) return 1;
        else if (B == 1) return A % C;

        long temp = pow(A, B / 2, C);

        if (B % 2 == 0)
            return temp * temp % C;
        else
            return ((temp * temp % C) * A) % C;
    }
}
