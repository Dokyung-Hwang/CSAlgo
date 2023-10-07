package algorithm.solution.dohyoungK.linkedList;

import algorithm.problem.linkedList.P5397;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class S5397 implements P5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            findPassword(br, bw);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static void findPassword(BufferedReader br, BufferedWriter bw) throws IOException {
        String password = br.readLine();

        Deque<Character> right = new ArrayDeque<>();
        Deque<Character> left = new ArrayDeque<>();

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            switch (c) {
                case '<':
                    if (!left.isEmpty()) {
                        right.addFirst(left.pollLast());
                    }
                    break;
                case '>':
                    if (!right.isEmpty()) {
                        left.add(right.poll());
                    }
                    break;
                case '-':
                    if (!left.isEmpty()) {
                        left.pollLast();
                    }
                    break;
                default:
                    left.add(c);
                    break;
            }
        }

        for (char c : left) bw.write(c);
        for (char c : right) bw.write(c);
    }
}
