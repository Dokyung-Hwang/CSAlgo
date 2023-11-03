package algorithm.solution.NtoZero_LST.boj.stack2;

import algorithm.problem.baekjoon.stack.advance.P4949;

import java.util.*;
import java.io.*;

public class S4949 implements P4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String line = br.readLine();
            if(line.equals(".")) break;

            Stack<String> stack = new Stack<>();

            String[] sentence = line.split("");
            for(String character : sentence) {
                switch (character) {
                    case ("("):
                    case ("["):
                        stack.push(character);
                        break;
                    case (")"):
                        if(!stack.isEmpty() && stack.peek().equals("("))
                            stack.pop();
                        else stack.push(")");
                        break;
                    case ("]"):
                        if(!stack.isEmpty() && stack.peek().equals("["))
                            stack.pop();
                        else stack.push("]");
                        break;
                }
            }
            if (stack.empty())
                bw.write("yes"+"\n");
            else
                bw.write("no"+"\n");
        }
            bw.close();
    }
}
