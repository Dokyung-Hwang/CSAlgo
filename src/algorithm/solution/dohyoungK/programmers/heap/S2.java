package algorithm.solution.dohyoungK.programmers.heap;

import algorithm.problem.programmers.heap.P2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S2 implements P2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,4}, {7,9}, {1000,3}}));
    }

// TODO:
//  2차원 배열 jobs를 입력받아
//  이전 작업의 실행중에 요청이 들어온 작업들을
//  각 작업의 요청부터 종료까지의 시간의 평균이
//  최소가 되도록 실행하고 그 평균값 리턴

// TODO:
//  이전 작업 실행중 요청이 들어온 작업들을
//  요청 시간 순으로 정렬하고
//  우선순위 큐에 넣어 소요시간이 적은 순서대로 실행

//  테스트 케이스
//  [[0, 3], [10, 1]] => 2
//  [[7, 8], [3, 5], [9, 6]] => 9
//  [[1, 4], [7, 9], [1000, 3]] => 5
//  [[0, 1], [2, 3], [2, 2]] => 2

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int sum = 0;
        int start = 0;
        int end = 0;
        int index = 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));
        pq.add(jobs[0]);

        while (!pq.isEmpty()) {
            int[] job = pq.poll();
            start = job[0];
            end = Math.max(start, end) + job[1];
            sum += end - start;

            while (index < jobs.length && (pq.isEmpty() || jobs[index][0] < end)) {
                pq.add(jobs[index++]);
            }
        }

        return sum / jobs.length;
    }
}
