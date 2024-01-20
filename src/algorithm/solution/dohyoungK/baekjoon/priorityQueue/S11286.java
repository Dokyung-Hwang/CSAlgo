package algorithm.solution.dohyoungK.baekjoon.priorityQueue;

import algorithm.problem.baekjoon.priorityQueue.P11286;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S11286 implements P11286 {
// TODO: 절댓값 힙 조건에 따라 최소값 출력하기 (절댓값 같을 때 음수 뽑기)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> positive = new PriorityQueue<>();
        PriorityQueue<Integer> negative = new PriorityQueue<>(Comparator.reverseOrder());
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                positive.add(num);
            } else if (num < 0) {
                negative.add(num);
            } else {
                int positiveNum = Integer.MAX_VALUE;
                int negativeNum = Integer.MAX_VALUE;
                if (!positive.isEmpty()) {
                    positiveNum = positive.peek();
                }
                if (!negative.isEmpty()) {
                    negativeNum = Math.abs(negative.peek());
                }

                if (positive.isEmpty() && negative.isEmpty()) bw.write(0 + "\n");
                else {
                    if (positiveNum >= negativeNum) {
                        bw.write(negative.poll() + "\n");
                    } else {
                        bw.write(positive.poll() + "\n");
                    }
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
