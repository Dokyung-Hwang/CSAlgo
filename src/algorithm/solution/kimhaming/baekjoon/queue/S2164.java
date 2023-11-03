package algorithm.solution.kimhaming.baekjoon.queue;

import algorithm.problem.baekjoon.queue.P2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S2164 implements P2164 {
    // https://velog.io/@haminggu/백준Java-카드2
    /**
     * Todo:
     *  1. BufferedReader를 사용하여 입력받을 수 있는 객체 br 생성
     *  2. Integer 형식을 저장할 수 있는 큐 객체 q 생성
     *  3. 정수 N 입력받기
     *  4. 1부터 N까지의 수 큐에 넣기
     *  5. 큐의 크기가 1보다 큰 동안 반복:
     *      - 큐에서 한 원소를 제거 (큐의 특성상 가장 먼저 저장된 원소부터 제거된다. 가장 위에 있는)
     *      - 다음 원소를 큐의 맨 뒤로 옮기기 (poll() -> offer())
     *  6. 큐에서 마지막으로 남은 원소를 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++)
            q.offer(i); // 1, 2, 3, 4 순회하며 저장

        while(q.size() > 1) {
            q.poll();   //  offer() 메서드로 저장한 순서대로 poll() 하게 됩니다. 1 -> 2 -> ... -> N
            q.offer(q.poll());  // 2 꺼내어 4 뒤에 줄서기하듯이 저장 => 3, 4, 2
        }

        System.out.println(q.poll());
    }
}
