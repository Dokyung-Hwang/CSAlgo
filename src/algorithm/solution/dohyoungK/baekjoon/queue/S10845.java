package algorithm.solution.dohyoungK.baekjoon.queue;

import algorithm.problem.baekjoon.queue.P10845;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class S10845 implements P10845 {
// TODO:
//  총 명령어 개수 N과 명령어들을 입력받아
//  그 명령어대로 큐에 명령을 실행한다
//  System.out.println() 쓰면 입력 많을 때 시간초과

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] operations = br.readLine().split(" ");

            switch (operations[0]) {
                case "push": {
                    deque.add(Integer.valueOf(operations[1]));
                    break;
                }
                case "pop": {
                    if (!deque.isEmpty()) {
                        bw.write(deque.pollFirst() + "\n");
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
