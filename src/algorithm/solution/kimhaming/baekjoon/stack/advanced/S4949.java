package algorithm.solution.kimhaming.baekjoon.stack.advanced;

import algorithm.problem.baekjoon.stack.advance.P4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S4949 implements P4949 {
    // https://velog.io/@haminggu/백준Java-4949번-균형잡힌-세상
    // Todo:
    //  함수 checkBalance(s):
    //      스택 stack을 생성한다.
    //      문자열 s를 순회하면서 각 문자를 순서대로 확인한다:
    //          만약 현재 문자가 여는 괄호면,
    //              스택에 현재 문자를 push
    //          현재 문자가 닫는 괄호면,
    //              만약 스택이 비어있다면,
    //                  return "no"
    //              스택에서 꺼낸 괄호와 현재 괄호가 매칭되지 않으면,
    //                  return "no"
    //      만약 스택이 비어있다면,
    //          return "yes"
    //      아니면,
    //          return "no"

    //  main Program:
    //      입력 받기
    //      입력이 "." 이면 종료한다
    //      checkBalance 함수를 호출하여 결과를 출력한다.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals(".")) break;
            sb.append(checkBalanced(input)).append('\n');
        }

        System.out.println(sb);
    }

    //
    public static String checkBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == ']') {
                if (stack.isEmpty()) return "no";
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[')) return "no";
            }
        }

        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
//        String s = input(); // 한 줄 입력
//        for (int i = 0; i < length; i++) {  // 문자열의 길이를 순회하는 동안
//
//            char c = s.charAt();    // i 번째 문자
//
//            // 여는 괄호일 경우 스택에 넣는다.
//            if (c == '(') {
//                stack.push(c);
//            }
//
//            // 아래는 모두 닫는 괄호일 경우들
//
//            // 스택이 비어있는 경우 == 닫는 괄호를 입력받았으나 pop할 원소가 없는 경우
//            else if (stack.empty()) {
//                return "NO";
//            }
//            // 그렇지 않다면 stack 원소를 pop 한다.
//            else {
//                stack.pop();
//            }
//        }
//        /*
//        모든 검사 마치고 스택에 잔여 요소가 있으면 여는 괄호가 많은 경우는 "NO"
//        스택이 비어있으면, 온전한 수식이므로 "YES" 가 된다.
//         */
//        if (stack.empty()) {
//            return "YES";
//        } else {
//            return "NO";
//        }
//    }
