package algorithm.solution.dohyoungK.baekjoon.stack.advance;

import algorithm.problem.baekjoon.stack.advance.P10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class S10799 implements P10799 {
// TODO:
//  쇠막대기의 시작, 끝을 레이저를 "(", ")" 로 표현할 때
//  괄호 문자열을 입력받아
//  조각난 쇠막대의 총 개수 출력

// TODO:
//  어차피 모든 케이스의 괄호쌍은 올바르게 들어오므로
//  닫는 괄호일 때 그게 레이저의 괄호인지
//  쇠막대의 괄호인지 구분해서 조각 합 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] brackets = br.readLine().split("");
        Deque<String> deque = new ArrayDeque<>();
        int result = 0;

        for (int i = 0; i < brackets.length; i++) {
            if (deque.isEmpty() || brackets[i].equals("(")) {
                deque.add(brackets[i]);
            } else if (brackets[i].equals(")")) {
                deque.pollLast();

                if (brackets[i - 1].equals("(")) { // 레이저일 때
                    result += deque.size();
                } else { // 쇠막대기 끝일 때
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
