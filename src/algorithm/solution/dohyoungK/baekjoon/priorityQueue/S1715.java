package algorithm.solution.dohyoungK.baekjoon.priorityQueue;

import algorithm.problem.baekjoon.priorityQueue.P1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class S1715 implements P1715 {
// TODO: N개의 카드 묶음을 최소 몇 번 비교해야하는지 출력 (작은 순서대로)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        while (N-- > 0) {
            pq.add(Long.parseLong(br.readLine()));
        }

        long result = 0;
        while (pq.size() > 1) {
            long sum = pq.poll() + pq.poll();
            pq.add(sum);
            result += sum;
        }

        System.out.println(result);
    }
}
