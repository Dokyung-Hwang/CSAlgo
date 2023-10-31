package algorithm.solution.smileDK.baejoon.queue;

import algorithm.problem.baekjoon.queue.P2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S2164 implements P2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        // Queue 1~N 삽입
        for(int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            q.poll();       // 첫 장 버리기
            q.offer(q.poll());       // 두번 째 장 빼서 Queue 삽입
        }

        System.out.println(q.peek());
    }
}
