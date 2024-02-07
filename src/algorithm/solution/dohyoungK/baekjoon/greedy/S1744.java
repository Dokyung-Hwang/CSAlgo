package algorithm.solution.dohyoungK.baekjoon.greedy;

import algorithm.problem.baekjoon.greedy.P1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1744 implements P1744 {
// TODO: 길이 N 수열의 최대 합 (두 수를 묶어 묶은 수를 곱해서 더하기)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            Integer num = Integer.parseInt(br.readLine());
            if (num > 0) positive.add(num);
            else negative.add(num);
        }

        long sum = 0;
        while (!positive.isEmpty()) {
            int first = positive.poll();

            if (positive.isEmpty()) sum += first;
            else {
                int second = positive.poll();
                if (first == 1 || second == 1) { // 1은 곱하는 거 보다 더하기
                    sum += first + second;
                } else sum += (long) first * second;
            }
        }

        while (!negative.isEmpty()) {
            int first = negative.poll();

            if (negative.isEmpty()) sum += first;
            else {
                int second = negative.poll();
                sum += (long) first * second;
            }
        }

        System.out.println(sum);
    }
}
