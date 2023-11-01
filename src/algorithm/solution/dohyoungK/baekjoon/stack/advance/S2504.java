package algorithm.solution.dohyoungK.baekjoon.stack.advance;

import algorithm.problem.baekjoon.stack.advance.P2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//  result            4            -> 22                  -> 28
//  value   2 -> 4 -> 2 -> 6 -> 18 -> 6 -> 2 -> 1    -> 2 -> 6 -> 3 -> 1

public class S2504 implements P2504 {
// TODO:
//  괄호 문자열을 입력받아 5가지 규칙에 따라 최종 결과 값을 출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String brackets = br.readLine();
        Deque<String> deque = new ArrayDeque<>();
        int result = 0; // 최종 결과
        int value = 1; // 각 괄호가 끝날 때까지의 값

        for (int i = 0; i < brackets.length(); i++) {
            String bracket = String.valueOf(brackets.charAt(i));

            if (bracket.equals("(")) {
                deque.add(bracket);
                value *= 2;
            } else if (bracket.equals("[")) {
                deque.add(bracket);
                value *= 3;
            } else if (bracket.equals(")")) {
                if (deque.isEmpty() || deque.peekLast().equals("[")) { // 스택이 비어있거나 괄호쌍이 안맞으면
                    System.out.println(0);
                    return;
                } else if (brackets.charAt(i - 1) == '(') { // 스택에 숫자가 들어있거나 괄호쌍이 맞을 때
                    result += value;
                }
                deque.pollLast();
                value /= 2;
            } else if (bracket.equals("]")) {
                if (deque.isEmpty() || deque.peekLast().equals("(")) { // 스택이 비어있거나 괄호쌍이 안맞으면
                    System.out.println(0);
                    return;
                } else if (brackets.charAt(i - 1) == '[') { // 스택에 숫자가 들어있거나 괄호쌍이 맞을 때
                    result += value;
                }
                deque.pollLast();
                value /= 3;
            }
        }

        if (!deque.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(result);
    }
}
