package algorithm.solution.smileDK.baejoon.priorityQueue;

import algorithm.problem.baekjoon.priorityQueue.P11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S11286 implements P11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {

            //  2, -1
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Math.abs(o1);
                int b = Math.abs(o2);
                if (a > b) return a - b;
                else if (a == b) return o1 - o2;
                else return -1;
            }
        });

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
