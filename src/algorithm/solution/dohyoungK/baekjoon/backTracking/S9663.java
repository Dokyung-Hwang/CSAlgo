package algorithm.solution.dohyoungK.baekjoon.backTracking;

import algorithm.problem.baekjoon.backTracking.P9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S9663 implements P9663 {
// TODO:
//  N이 주어졌을 때, N X N인 체스판 위에
//  퀸 N개를 놓는 방법의 수

// TODO:
//  한 행에 퀸 1개가 무조건 놓아져야 하므로
//  한 행의 1열부터 끝까지 퀸을 놓고
//  그 다음 행에도 퀸을 놓을 자리가 있는지 없는지 확인하며 진행
//  (직접 체스판을 만들어 채우면서 풀면 메모리 초과) (1차원 배열로 풀어야 메모리 초과가 안뜨는거 같은데?)

// TODO:
//  1차원 배열의 index를 queen의 행, value를 queen의 열로 나타내고
//  다음 행의 queen 위치를 chk(이전에 놓은 퀸들과 같은 열이면 X, 대각선이면 X)하면서 진행

    static int result = 0;
    static int[] queens; // index가 행 value가 열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        queens = new int[N];

        nQueen(N, 0);

        System.out.println(result);
    }

    private static void nQueen(int N, int row) {
        if (row == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) { // row의 열 반복
            if (queenChk(row, i)) {
                queens[row] = i;
                nQueen(N, row + 1);
            }
        }
    }

    private static boolean queenChk(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 같은 열일 때 or 대각선일 때
            if (queens[i] == col || row - i == Math.abs(col - queens[i])) {
                return false;
            }
        }

        return true;
    }
}
