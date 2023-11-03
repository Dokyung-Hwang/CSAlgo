package algorithm.solution.dohyoungK.baekjoon.recursion;

import algorithm.problem.baekjoon.recursion.P2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2630 implements P2630 {
// TODO:
//  N X N 2차원 행렬 크기의 종이가 존재할 때
//  각 칸의 값에 따라 종이를 나누기

    static int[] result = new int[2];

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
            if (num.equals("0")) {
                result[0]++;
            } else {
                result[1]++;
            }
        } else {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    dividePaper(paper, N / 2, row + N / 2 * i, col + N / 2 * j);
                }
            }
        }
    }
}
