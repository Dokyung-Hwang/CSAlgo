package algorithm.solution.smileDK.baejoon.priorityQueue;

import algorithm.problem.baekjoon.priorityQueue.P2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S2075 implements P2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                pQ.offer(Integer.parseInt(st.nextToken()));
            }
        }

        // n 개 만큼 queue 에서 삭제시키기
        for (int i = 0; i < n - 1; i++) {
            pQ.remove();
        }

        System.out.println(pQ.peek());
    }
}
