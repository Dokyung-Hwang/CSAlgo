package algorithm.solution.dohyoungK.baekjoon.recursion;

import algorithm.problem.baekjoon.recursion.P2447;

import java.io.*;
import java.util.Arrays;

public class S2447 implements P2447 {
// TODO:
//  N을 입력받아 N X N 정사각형 형태로
//  3 X 3 패턴을 출력하기
    static String[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        result = new String[N][N];

        for (String[] str : result) Arrays.fill(str, " ");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                star(N / 3, 3 * i + j + 1, N / 3 * i, N / 3 * j);
            }
        }

        for (String[] str : result) {
            bw.write(String.join("", str) + "\n");
        }
        bw.flush();
        bw.close();
    }

//    row : 시작 행 인덱스
//    col : 시작 열 인덱스
//    section : 아래 그림과 같은 구역 번호

//    | 1 | 2 | 3 |
//    | 4 | 5 | 6 |
//    | 7 | 8 | 9 |
    private static void star(int N, int section, int row, int col) {
        if (section != 5) { // * 로 채우기
            if (N == 1) {
                result[row][col] = "*";
                return;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    star(N / 3, 3 * i + j + 1, N / 3 * i + row, N / 3 * j + col);
                }
            }
        }
    }
}
