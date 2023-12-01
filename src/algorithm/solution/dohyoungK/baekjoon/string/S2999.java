package algorithm.solution.dohyoungK.baekjoon.string;

import algorithm.problem.baekjoon.string.P2999;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2999 implements P2999 {
// TODO:
//  암호화된 메시지를 해독해 출력

// TODO:
//  R와 C를 구해서 행과 열 반대 순서로 메시지를 해독해 출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = br.readLine();
        int N = message.length();
        int R = 0;
        int C = 0;

        for (int i = (int) Math.sqrt(N); i > 0; i--) {
            if (N % i == 0) {
                R = i;
                C = N / R;
                break;
            }
        }

        char[] result = new char[N];
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (i % R == 0) index = i / R + i % R;
            else index = i / R + i % R * C;

            result[index] = message.charAt(i);
        }

        System.out.println(String.valueOf(result));
    }
}
