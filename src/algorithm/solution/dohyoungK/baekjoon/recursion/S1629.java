package algorithm.solution.dohyoungK.baekjoon.recursion;

import algorithm.problem.baekjoon.recursion.P1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1629 implements P1629 {
// TODO:
//  A를 B번 곱한 수를 찾기, 수가 커질 수 있으니 C로 나눈 나머지 출력

// TODO: (입력에 2,147,483,647)
//  수학문제
//  10의 11제곱을 12로 나눈 나머지를 구하려면      = (4 * 4 % 12) * 4 % 12 = 4
//  10의 5제곱을 12로 나눈 나머지                 = (4 * 4 % 12) * 4 % 12 = 4
//  10의 2제곱을 12로 나눈 나머지                 = 10 * 10 % 12 = 4
//  10의 1제곱을 12로 나눈 나머지                 = 10

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        long A = Long.parseLong(nums[0]);
        long B = Long.parseLong(nums[1]);
        long C = Long.parseLong(nums[2]);

        System.out.println(power(A, B, C));
    }

    private static long power(long A, long B, long C) {
        if (B == 1) {
            return A % C;
        }

        long result = power(A, B / 2, C);
        result = result * result % C;

        if (B % 2 == 0) {
            return result;
        } else {
            return result * A % C;
        }
    }
}
