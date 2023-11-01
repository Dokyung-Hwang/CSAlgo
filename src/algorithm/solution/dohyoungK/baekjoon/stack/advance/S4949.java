package algorithm.solution.dohyoungK.baekjoon.stack.advance;

import algorithm.problem.baekjoon.stack.advance.P4949;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class S4949 implements P4949 {
// TODO:
//  단어의 수 N과 N개 만큼의 단어를 입력받아
//  올바른 단어 수 세기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();

            if (input.equals(".")) {
                break;
            }

            Deque<String> deque = new ArrayDeque<>();
            for (String s : input.split("")) {
                if (s.equals("(") || s.equals("[")) {
                    deque.add(s);
                } else if (s.equals(")")) {
                    if (deque.isEmpty() || deque.peekLast().equals("[")) {
                        deque.add(s);
                        break;
                    }
                    deque.pollLast();
                } else if (s.equals("]")) {
                    if (deque.isEmpty() || deque.peekLast().equals("(")) {
                        deque.add(s);
                        break;
                    }
                    deque.pollLast();
                }
            }

            if (deque.isEmpty()) {
                bw.write("yes\n");
            } else  {
                bw.write("no\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
