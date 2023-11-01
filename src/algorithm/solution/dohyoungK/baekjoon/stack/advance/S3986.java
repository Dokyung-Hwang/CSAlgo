package algorithm.solution.dohyoungK.baekjoon.stack.advance;

import algorithm.problem.baekjoon.stack.advance.P3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class S3986 implements P3986 {
// TODO:
//  단어의 수 N과 N개 만큼의 단어를 입력받아
//  올바른 단어 수 세기

// TODO:
//  A, B를 괄호 쌍으로 생각하고 풀면 끝

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            String[] word = br.readLine().split("");
            Deque<String> deque = new ArrayDeque<>();

            for (String s : word) {
                if (deque.isEmpty()) {
                    deque.add(s);
                    continue;
                }

                if (s.equals("A")) {
                    if (deque.peekLast().equals("A")) {
                        deque.pollLast();
                    } else {
                        deque.add(s);
                    }
                } else {
                    if (deque.peekLast().equals("B")) {
                        deque.pollLast();
                    } else {
                        deque.add(s);
                    }
                }
            }

            if (deque.isEmpty()) {
                result++;
            }
        }
        System.out.println(result);
    }
}
