package algorithm.solution.dohyoungK.stack;

import algorithm.problem.stack.P10828;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class S10828 implements P10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            switch (command.split(" ")[0]) {
                case "push":
                    deque.add(Integer.parseInt(command.split(" ")[1]));
                    break;
                case "pop":
                    if (!deque.isEmpty()) {
                        System.out.println(deque.pollLast());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "top":
                    if (!deque.isEmpty()) {
                        System.out.println(deque.peekLast());
                    } else {
                        System.out.println(-1);
                    }
                    break;
            }
        }
    }
}
