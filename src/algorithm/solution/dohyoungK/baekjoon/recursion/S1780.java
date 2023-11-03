package algorithm.solution.dohyoungK.baekjoon.recursion;

import algorithm.problem.baekjoon.recursion.P1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1780 implements P1780 {
// TODO:
//  N X N 2차원 행렬 크기의 종이가 존재할 때
//  각 칸의 값에 따라 종이를 나누기

    static int[] result = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] paper = new String[N][N];

        for (int i = 0; i < N; i++) {
            paper[i] = br.readLine().split(" ");
        }

        dividePaper(paper, N, 0, 0);

        for (int num : result) System.out.println(num);
    }

//     N : 행과 열 길이
//     row : 행 시작 인덱스
//     col : 열 시작 인덱스

//    | 1 | 2 | 3 |
//    | 4 | 5 | 6 |
//    | 7 | 8 | 9 |
    private static void dividePaper(String[][] paper, int N, int row, int col) {
        String num = paper[row][col];
        boolean same = true;

        Loop1 :
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!paper[row + i][col + j].equals(num)) {
                    same = false;
                    break Loop1;
                }
            }
        }

        if (same) {
            if (num.equals("-1")) {
                result[0]++;
            } else if (num.equals("0")) {
                result[1]++;
            } else {
                result[2]++;
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    dividePaper(paper, N / 3, row + N / 3 * i, col + N / 3 * j);
                }
            }
        }
    }
}
