package algorithm.solution.smileDK.baejoon.recursion;

import algorithm.problem.baekjoon.recursion.P1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//TODO: 종이의 개수
// Input: N(1<=N<=3^7, N=3^k꼴), N x N 크기의 정방행렬(element = -1, 0, 1)
// NxN 정방행렬로 표현된 종이
// 종이의 각 칸 -1, 0, 1 저장
// 다음과 같은 규칙으로 자르기
// 1. 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용
// 2. (1)이 아닌 경우 종이를 같은 크기의 종이 9개로 자르고 각각의 잘린 종이에 대해서 (1)의 과정을 반복
// Output: (-1, 0, 1)로만 채워진 종이의 갯수 출력


public class S1780 implements P1780 {
    private static int[][] paper;
    private static int minus = 0;
    private static int zero = 0;
    private static int plus = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cutPaper(0, 0, n);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    public static void cutPaper(int x, int y, int size) {
        if (checkSameNumber(x, y, size)) {
            if (paper[x][y] == -1) minus++;
            else if (paper[x][y] == 0) zero++;
            else plus++;
            return;
        }

        int thirdSize = size/3;

        cutPaper(x, y, thirdSize);
        cutPaper(x, y+thirdSize, thirdSize);
        cutPaper(x, y+thirdSize+thirdSize, thirdSize);
        cutPaper(x+thirdSize, y, thirdSize);
        cutPaper(x+thirdSize, y+thirdSize, thirdSize);
        cutPaper(x+thirdSize, y+thirdSize+thirdSize, thirdSize);
        cutPaper(x+thirdSize+thirdSize, y, thirdSize);
        cutPaper(x+thirdSize+thirdSize, y+thirdSize, thirdSize);
        cutPaper(x+thirdSize+thirdSize, y+thirdSize+thirdSize, thirdSize);
    }

    public static boolean checkSameNumber(int x, int y, int size) {
        int number = paper[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (number != paper[i][j]) return false;
            }
        }
        return true;
    }
}
