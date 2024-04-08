package algorithm.solution.smileDK.baejoon.stack;

import algorithm.problem.baekjoon.stack.P10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S10773 implements P10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int sum = 0;

        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());
            if (!stack.empty() && num == 0)
                stack.pop();
            else
                stack.push(num);
        }

        for (int i : stack)
            sum += i;

        System.out.println(sum);
    }
}
