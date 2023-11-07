package algorithm.solution.smileDK.baejoon.recursion;

import algorithm.problem.baekjoon.recursion.P2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO:   색종이 만들기 (분할 정복 - 재귀, 탐색)
//        Input: N(N = 2^k, 1<=k<=7)
//        N x N 정사각형 색종이
//        1: 파란색 / 0: 하얀색
//        모두 같은 색으로 칠해져 있지 않으면 N/2 자르기 (N/2 x N/2)

public class S2630 implements P2630 {

    public static int[][] paper;
    public static int white = 0;
    public static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];


        // 2차원 배열 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cutPaper(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void cutPaper(int x, int y, int size) {

        // 잘려진 종이가 같은 색상인 지 확인
        if (checkColor(x, y, size)) {
            if (paper[x][y] == 0) white++;
            else blue++;
            return;
        }


        int halfSize = size / 2;

        // Recursion
        // 순서대로 (2, 1, 3, 4) 분면
        // 0 0 4 | 0 4 4 | 4 0 4 | 4 4 4
        // 0 0 4(2사) -> 0 0 2 | 0 2 2 | 2 0 2 | 2 2 2
        // 0 4 4(1사) -> 0 4 2 | 0 6 2 | 2 4 2 | 6 6 2
        // 4 0 4(3사) -> 4 0 2 | 4 2 2 | 6 0 2 | 6 6 2
        // 4 4 4(4사) -> 4 4 2 | 4 6 2 | 6 4 2 | 6 6 2
        cutPaper(x, y, halfSize);
        cutPaper(x, y + halfSize, halfSize);
        cutPaper(x + halfSize, y, halfSize);
        cutPaper(x + halfSize, y + halfSize, halfSize);
    }


    // 잘려진 종이의 색상이 같은지 체크하는 메서드
    public static boolean checkColor(int x, int y, int size) {
        int color = paper[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                // 색상이 같지 않다면
                if (color != paper[i][j]) return false;
            }
        }
        return true;
    }
}
