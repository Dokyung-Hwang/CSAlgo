package algorithm.solution.dohyoungK.programmers.heap;

import algorithm.problem.programmers.heap.P1;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class S1 implements P1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,9,10,12}, 7));
    }

// TODO:
//  스코빌지수 배열과 최소 스코빌지수 K를 입력받아
//  스코빌지수를 합치는 공식대로 배열 중 최소값 2개를 섞었을 때
//  가장 작은 수가 K 이상일 때까지의 섞은 횟수 리턴

// TODO:
//  우선순위 큐에 스코빌지수를 넣고
//  while문 내에서 가장 작은 수 2개를 빼면서
//  가장 작은 수가 K 이상이면 섞은 수 리턴

    public static int solution(int[] scoville, int K) {
        int result = 0;
        PriorityQueue<Integer> pq = Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new));

        while (pq.peek() < K) {
            if (pq.size() < 2) return -1;

            pq.add(pq.poll() + (pq.poll() * 2));
            result++;
        }

        return result;
    }
}
