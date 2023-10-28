package algorithm.solution.dohyoungK.baekjoon.deque;

import algorithm.problem.baekjoon.deque.P10866;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class S10866 implements P10866 {
// TODO:
//  명령 개수 N과 N개의 명령어들을 입력받아
//  덱을 명령대로 수행

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String[] operations = br.readLine().split(" ");

            switch (operations[0]) {
                case "push_front": {
                    deque.addFirst(Integer.valueOf(operations[1]));
                    break;
                }
                case "push_back": {
                    deque.addLast(Integer.valueOf(operations[1]));
                    break;
                }
                case "pop_front": {
                    if (!deque.isEmpty()) {
                        bw.write(deque.pollFirst() + "\n");
                    } else {
                        bw.write(-1 + "\n");
                    }
                    break;
                }
                case "pop_back": {
                    if (!deque.isEmpty()) {
                        bw.write(deque.pollLast() + "\n");
                    } else {
                        bw.write(-1 + "\n");
                    }
                    break;
                }
                case "size": {
                    bw.write(deque.size() + "\n");
                    break;
                }
                case "empty": {
                    if (!deque.isEmpty()) {
                        bw.write(0 + "\n");
                    } else {
                        bw.write(1 + "\n");
                    }
                    break;
                }
                case "front": {
                    if (!deque.isEmpty()) {
                        bw.write(deque.peekFirst() + "\n");
                    } else {
                        bw.write(-1 + "\n");
                    }
                    break;
                }
                case "back": {
                    if (!deque.isEmpty()) {
                        bw.write(deque.peekLast() + "\n");
                    } else {
                        bw.write(-1 + "\n");
                    }
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
