package algorithm.solution.NtoZero_LST.boj.deque;

import algorithm.problem.baekjoon.deque.P1021;

import java.util.*;
import java.io.*;

public class S1021 implements P1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        MyDeque my = new MyDeque(N);

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int k = Integer.parseInt(st.nextToken());
            int first = my.deque.getFirst();
            int last = my.deque.getLast();

            int firstGap = Math.abs(k-first);
            int LastGap = Math.abs(k-last);

            if (firstGap<LastGap) {
//                while(my.deque.getFirst())
            } else {

            }
        }

    }

    static class MyDeque {
        Deque<Integer> deque = new ArrayDeque();
        int count = 0;

        public MyDeque(int N) {
            for(int i=1; i<=N; i++) {
                deque.addLast(i);
            }
        }

        //1번 연산
        public void removeFirst() {
            deque.removeFirst();
        }

        //2번 연산
        public void moveLeft() {
            deque.addLast(deque.removeFirst());
            count++;
        }

        //3번 연산
        public void moveRight() {
            deque.addFirst(deque.removeLast());
            count++;
        }
    }
}
