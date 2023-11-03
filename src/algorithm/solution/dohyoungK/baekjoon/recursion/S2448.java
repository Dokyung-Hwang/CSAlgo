package algorithm.solution.dohyoungK.baekjoon.recursion;

import algorithm.problem.baekjoon.recursion.P2448;

import java.io.*;
import java.util.Arrays;

public class S2448 implements P2448 {
    static String[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        result = new String[N][2 * N - 1];

        for (String[] str : result) Arrays.fill(str, " ");

        star(N, 0, N - 1);

        for (String[] str : result) {
            bw.write(String.join("", str) + "\n");
        }
        bw.flush();
        bw.close();
    }

//    row : 삼각형의 꼭짓점 시작 행 인덱스
//    col : 삼각형의 꼭짓점 시작 열 인덱스
//    section : 아래 그림과 같은 구역 번호

//    N > 3 일때
//    |   | * |   |
//    | * |   | * |

//    N = 3 일때
//    | 1  | 2  | 3  | 4  | 5  |
//    | 6  | 7  | 8  | 9  | 10 |
//    | 11 | 12 | 13 | 14 | 15 |
    private static void star(int N, int row, int col) {
        if (N == 3) {
            result[row][col] = "*";
            result[row + 1][col - 1] = "*";
            result[row + 1][col + 1] = "*";
            for (int i = 0; i < 5; i++) result[row + 2][col - 2 + i] = "*";
        } else {
            star(N / 2, row, col);
            star(N / 2, N / 2 + row, col - N / 2);
            star(N / 2, N / 2 + row, col + N / 2);
        }
    }
}
