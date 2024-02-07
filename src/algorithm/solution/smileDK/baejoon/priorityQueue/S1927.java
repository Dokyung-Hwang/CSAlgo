package algorithm.solution.smileDK.baejoon.priorityQueue;

import algorithm.problem.baekjoon.priorityQueue.P1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class S1927 implements P1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (priorityQueue.isEmpty())
                    sb.append("0").append("\n");
                else
                    sb.append(priorityQueue.poll()).append("\n");
            }
            else {
                priorityQueue.offer(x);
            }
        }

        System.out.println(sb);
    }
}
