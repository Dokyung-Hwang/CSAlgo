package algorithm.solution.NtoZero_LST.boj.stack2;

import algorithm.problem.baekjoon.stack.advance.P3986;

import java.util.*;
import java.io.*;

public class S3986 implements P3986 {
    static Stack<String> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int good = 0;
        for(int i=0; i<N; i++) {
            stack = new Stack<>();
            char[] chars = br.readLine().toCharArray();
            for(char c : chars) {
                if(stack.isEmpty() || !stack.peek().equals(c+"")) {
                    stack.push(c+"");
                }
                else if(!stack.isEmpty() && !stack.peek().equals(c+"")) {
                    break;
                }
                else {
                    stack.pop();
                }
            }
            if(stack.isEmpty()) good++;
        }

        bw.write(String.valueOf(good));
        bw.close();
    }
}
