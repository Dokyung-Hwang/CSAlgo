package algorithm.solution.dohyoungK.baekjoon.priorityQueue;

import algorithm.problem.baekjoon.priorityQueue.P1781;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1781 implements P1781 {
// TODO: N개의 문제 중 푼 개수만큼 컵라면을 준다고 했을 때,
//  받을 수 있는 최대 컵라면 수 구하기

// TODO: 각 일차까지 풀 수 있는 문제를 pq에 넣고
//  pq.size보다 많으면 컵라면 개수 적은 것을 빼기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, List<Integer>> problems = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());

            List<Integer> values = problems.getOrDefault(deadline ,new ArrayList<>());
            values.add(Integer.parseInt(st.nextToken()));
            problems.put(deadline, values);
        }

        List<Integer> keys = new ArrayList<>(problems.keySet());
        Collections.sort(keys);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int deadline : keys) {
            pq.addAll(problems.get(deadline));

            while (pq.size() > deadline) {
                pq.poll();
            }
        }

        int result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }
        System.out.println(result);
    }
}
