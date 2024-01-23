package algorithm.solution.smileDK.baejoon.priorityQueue;

import algorithm.problem.baekjoon.priorityQueue.P1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1655 implements P1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> minPQ = new PriorityQueue<>();
        Queue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);


        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(minPQ.size() == maxPQ.size())
                maxPQ.offer(num);
            else
                minPQ.offer(num);

            if(!minPQ.isEmpty() && !maxPQ.isEmpty())
                if(minPQ.peek() < maxPQ.peek()){
                    int tmp = minPQ.poll();
                    minPQ.offer(maxPQ.poll());
                    maxPQ.offer(tmp);
                }

            sb.append(maxPQ.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
