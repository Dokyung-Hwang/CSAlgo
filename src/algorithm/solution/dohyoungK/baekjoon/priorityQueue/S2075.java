package algorithm.solution.dohyoungK.baekjoon.priorityQueue;

import algorithm.problem.baekjoon.priorityQueue.P2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class S2075 implements P2075 {
// TODO: N x N 개의 수 중 N번째로 큰 수 찾기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            pq.addAll(Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList()));
        }

        for (int i = 0; i < N - 1; i++) {
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}
