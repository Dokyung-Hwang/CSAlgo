package algorithm.solution.dohyoungK.baekjoon.priorityQueue;

import algorithm.problem.baekjoon.priorityQueue.P1655;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S1655 implements P1655 {
// TODO: 수를 입력받을 때 마다 중간 값을 출력하기

// TODO:
//  중앙값과 같거나 작은 값은 최대힙에 저장, 큰 값은 최소 힙에 저장하고
//  중앙값은 최대힙의 루트
//  값이 들어올 때 최소힙과 최대힙의 루트를 비교해 최소힙 루트가 작으면 서로 변경

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 중간값보다 큰 값들
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // 중간값보다 작은 값들
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            if (minHeap.isEmpty()) {
                bw.write(maxHeap.peek() + "\n");
                continue;
            } else {
                if (maxHeap.peek() > minHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }
            }

            bw.write(maxHeap.peek() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
