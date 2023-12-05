package algorithm.solution.dohyoungK.baekjoon.recursion;

import algorithm.problem.baekjoon.recursion.P1992;

import java.io.*;

public class S1992 implements P1992 {
// TODO:
//  N X N 2차원 행렬 크기의 종이가 존재할 때
//  각 칸의 값에 따라 종이를 나누기

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] data = new String[N][N];

        for (int i = 0; i < N; i++) {
            data[i] = br.readLine().split("");
        }

        quadTreeCompression(data, N, 0, 0);
        bw.flush();
        bw.close();
    }

    private static void quadTreeCompression(String[][] data, int N, int row, int col) throws IOException {
        String num = data[row][col];
        boolean same = true;

        Loop1 :
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!data[row + i][col + j].equals(num)) {
                    same = false;
                    break Loop1;
                }
            }
        }

        if (same) {
            if (num.equals("0")) {
                bw.write("0");
            } else {
                bw.write("1");
            }
        } else {
            bw.write("(");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    quadTreeCompression(data, N / 2, row + N / 2 * i, col + N / 2 * j);
                }
            }
            bw.write(")");
        }
    }
}
