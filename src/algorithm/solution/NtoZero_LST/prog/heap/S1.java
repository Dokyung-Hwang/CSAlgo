package algorithm.solution.NtoZero_LST.prog.heap;

import algorithm.problem.programmers.heap.P1;
import java.util.*;

/*
    K <= 10^9 , 10억이므로 O(logN) 이하의 자료구조/알고리즘을 사용

    모든 음식의 스코빌 지수를 K이상으로 만들기 위해
    섞어야하는 횟수의 최소 값을 구해야 한다.

    count를 따로 세며 자료구조의 최소 값을 제외하는 알고리즘 필요
    최소 값 확인 -> 배열 O(1), 최소 힙 O(1)
    최소 값 제거 -> 배열 O(N), 최소 힙 O(logN) => 배열이 시간복잡도 초과함.

    => 최소 힙을 PriorityQueue로 구현한다.
*/
public class S1 implements P1 {
    public int solution(int[] scoville, int K) {
        int count = 0;
        // 자바에서는 최소 힙이 Default다. (루트에 최솟값이 오는 힙 구조)
        Queue<Integer> minHeap = new PriorityQueue<>();

        // scoville 배열을 우선순위 큐(최소 힙)로 변환
        for (int s : scoville) {
            minHeap.offer(s);
        }

        // 모든 음식의 스코빌 지수가 K 이상이 될 때까지 섞음
        while (minHeap.peek() < K) {
            // 여전히 최소 힙의 루트가 K보다 작으면서, 섞을 음식이 남아있지 않은 경우 -1 반환
            if (minHeap.size() < 2) {
                return -1;
            }

            int first = minHeap.poll(); // 최소 스코빌
            int second = minHeap.poll(); // 두 번째로 작은 스코빌

            int newThing = first + (second * 2); // 스코빌 지수 계산
            minHeap.offer(newThing); // 큐에 넣음
            count++; // 섞은 횟수 증가
        }

        return count;
    }
}
