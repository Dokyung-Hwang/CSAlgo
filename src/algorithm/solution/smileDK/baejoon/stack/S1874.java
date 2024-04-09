package algorithm.solution.smileDK.baejoon.stack;

import algorithm.problem.baekjoon.stack.P1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S1874 implements P1874 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int start = 0;


        for (int i = 0; i < n; i++) {
            int inputNum = Integer.parseInt(br.readLine());

            if(inputNum > start) {
                for(int j = start + 1; j <= inputNum; j++) {
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                start = inputNum; 	// 다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화
            }


            else if(stack.peek() != inputNum) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);
    }
}
