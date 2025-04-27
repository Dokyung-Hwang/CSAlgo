package algorithm.solution.smileDK.baejoon.stack;

import algorithm.problem.baekjoon.stack.P2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
    public int index;
    public int height;

    public Top(int index, int height) {
        this.index = index;
        this.height = height;
    }
}


public class S2493 implements P2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Top> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= number; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (stack.empty()) {
                sb.append("0").append(" ");
                stack.push(new Top(i, height));
            }
            else {
                while(true) {
                    if (stack.empty()) {
                        sb.append("0").append(" ");
                        stack.push(new Top(i, height));
                        break;
                    }
                    Top top = stack.peek();
                    if(top.height > height) {
                        sb.append(top.index).append(" ");
                        stack.push(new Top(i, height));
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
