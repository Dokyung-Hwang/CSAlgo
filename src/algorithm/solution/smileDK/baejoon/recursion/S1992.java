package algorithm.solution.smileDK.baejoon.recursion;

import algorithm.problem.baekjoon.recursion.P1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1992 implements P1992 {
    private static int[][] square;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        square = new int[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                square[i][j] = row.charAt(j) - 48;
            }
        }

        partition(0, 0, n);

        System.out.println(sb);
    }

    public static void partition(int x, int y, int size) {
        if (isCompression(x, y, size)) {
            sb.append(square[x][y]);
            return;
        }

        int half = size / 2;

        sb.append('(');

        partition(x, y, half);
        partition(x, y + half, half);
        partition(x + half, y, half);
        partition(x + half, y + half, half);

        sb.append(')');
    }

    public static boolean isCompression(int x, int y, int size) {
        int value = square[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (value != square[i][j]) return false;
            }
        }
        return true;
    }
}
