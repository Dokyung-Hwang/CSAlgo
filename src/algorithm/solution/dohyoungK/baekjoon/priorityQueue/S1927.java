package algorithm.solution.dohyoungK.baekjoon.priorityQueue;

import algorithm.problem.baekjoon.priorityQueue.P1927;

import java.io.*;
import java.util.PriorityQueue;

public class S1927 implements P1927 {
// TODO: 최소 힙에 따른 최소값 출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                pq.add(num);
            } else {
                if (pq.isEmpty()) bw.write(0 + "\n");
                else bw.write(pq.poll() + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
