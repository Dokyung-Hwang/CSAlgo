package algorithm.solution.dohyoungK.baekjoon.recursion;

import algorithm.problem.baekjoon.recursion.P1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1074 implements P1074 {
// TODO:
//  2의 N제곱 사이즈의 2차원 배열을 Z모양으로 탐색하면서
//  r행 c열을 몇번째로 방문하는지 출력

// TODO:
//  2 X 2 사이즈(N = 1)가 될 때까지 2차원 배열을 나누면서
//  입력받은 row, col 기준으로 몇 사분면으로 들어가는지 정하고
//  이동한 칸 수 result에 더해주기

    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]);
        int r = Integer.parseInt(nums[1]);
        int c = Integer.parseInt(nums[2]);

        traversal(N, r, c);
        System.out.println(result - 1);
    }

    private static void traversal(int N, int row, int col) {
        if (N == 1) {
            if (row == 0 && col == 0) {
                result += 1;
            } else if (row == 0 && col == 1) {
                result += 2;
            } else if (row == 1 && col == 0) {
                result += 3;
            } else if (row == 1 && col == 1) {
                result += 4;
            }
            return;
        }

        boolean up = false;
        boolean left = false;

        if (row < Math.pow(2, N - 1)) { // 입력받은 칸이 위쪽일 때
            up = true;
        }
        if (col < Math.pow(2, N - 1)) { // 입력받은 칸이 왼쪽일 때
            left = true;
        }

        if (up && left) { // 왼쪽 위
            traversal(N - 1, row, col);
        } else if (up && !left) { // 오른쪽 위
            result += Math.pow(2, 2 * N - 2);
            traversal(N - 1, row, (int) (col - Math.pow(2, N - 1)));
        } else if (!up && left) { // 왼쪽 아래
            result += 2 * Math.pow(2, 2 * N - 2);
            traversal(N - 1, (int) (row - Math.pow(2, N - 1)), col);
        } else if (!up && !left) { // 오른쪽 아래
            result += 3 * Math.pow(2, 2 * N - 2);
            traversal(N - 1, (int) (row - Math.pow(2, N - 1)), (int) (col - Math.pow(2, N - 1)));
        }
    }
}
