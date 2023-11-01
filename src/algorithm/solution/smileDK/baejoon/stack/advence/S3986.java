package algorithm.solution.smileDK.baejoon.stack.advence;

import algorithm.problem.baekjoon.stack.advance.P3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S3986 implements P3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;

        while(true) {
            s = br.readLine();
            if(s.equals(".")) {	// 종료 조건
                break;
            }
            sb.append(checkParentheses(s)).append('\n');
        }
        System.out.println(sb);
    }

    public static String checkParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(' || c == '[') {
                stack.push(c);
            }

            else if(c == ')') {
                // 스택이 비어있거나 pop할 원소가 소괄호랑 매칭이 안되는 경우
                if(stack.empty() || stack.peek() != '(') {
                    return "no";
                }
                else {
                    stack.pop();
                }
            }

            else if(c == ']') {
                // 스택이 비어있거나 pop할 원소가 대괄호랑 매칭이 안되는 경우
                if(stack.empty() || stack.peek() != '[') {
                    return "no";
                }
                else {
                    stack.pop();
                }
            }
        }

        if(stack.empty()) {
            return "yes";
        }
        else {
            return "no";
        }
    }
}
