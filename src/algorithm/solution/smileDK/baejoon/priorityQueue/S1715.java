package algorithm.solution.smileDK.baejoon.priorityQueue;

import algorithm.problem.baekjoon.priorityQueue.P1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class S1715 implements P1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            priorityQueue.offer(Integer.parseInt(br.readLine()));
        }

        int min = 0;
        while (priorityQueue.size() > 1){
            int sum = priorityQueue.poll() + priorityQueue.poll();
            min += sum;
            priorityQueue.offer(sum);
        }

        System.out.println(min);
    }
}
