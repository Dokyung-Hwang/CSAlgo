package algorithm.solution.dohyoungK.baekjoon.greedy;

import algorithm.problem.baekjoon.greedy.P1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1541 implements P1541 {
// TODO: 주어진 식에 괄호를 적절히 사용해 최소 결과를 구하기

// TODO: 덧셈만 먼저 계산한 뒤 뺄셈을 계산하기
//   100 - 10 - (20 + 30 + 40) - (50 + 60) - 70

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] expression = br.readLine().split("-");

        for (int i = 0; i < expression.length; i++) {
            String[] arr = expression[i].split("\\+");

            if (arr.length > 1) {
                int sum = 0;
                for (String s : arr) sum += Integer.parseInt(s);
                expression[i] = String.valueOf(sum);
            }
        }

        int result = Integer.parseInt(expression[0]);
        for (int i = 1; i < expression.length; i++) {
            result -= Integer.parseInt(expression[i]);
        }

        System.out.println(result);
    }
}
