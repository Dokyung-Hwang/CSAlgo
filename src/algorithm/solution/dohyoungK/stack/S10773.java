package algorithm.solution.dohyoungK.stack;

import algorithm.problem.stack.P10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class S10773 implements P10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input != 0) {
                deque.add(input);
            } else {
                deque.pollLast();
            }
        }

        System.out.println(deque.stream().mapToInt(e -> e).sum());
    }
}
