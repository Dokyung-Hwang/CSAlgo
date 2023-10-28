package algorithm.solution.dohyoungK.programmers.heap;

import algorithm.problem.programmers.heap.P3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S3 implements P3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }

// TODO:
//  I 숫자, D 1, D -1 종류의 명령어 배열에 따라
//  명령을 수행하고 모든 명령을 수행한 후의
//  큐 상태 리턴

// TODO:
//  최소 힙과 최대 힙 2개를 만들어서
//  최댓값 삭제 명령을 수행할 때에는 최대 힙에서 최댓값을 찾고 삭제
//  최솟값 삭제 명령을 수행할 때에는 최소 힙에서 최솟값을 찾고 삭제

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (String operation : operations) {
            String[] op = operation.split(" ");

            if (op[0].equals("I")) {
                minQueue.add(Integer.valueOf(op[1]));
                maxQueue.add(Integer.valueOf(op[1]));
            } else {
                if (Integer.parseInt(op[1]) == 1) {
                    // 최댓값 삭제
                    int max;
                    if (!maxQueue.isEmpty()) {
                        max = maxQueue.poll();
                        maxQueue.remove(max);
                        minQueue.remove(max);
                    }
                } else {
                    // 최솟값 삭제
                    int min;
                    if (!minQueue.isEmpty()) {
                        min = minQueue.poll();
                        minQueue.remove(min);
                        maxQueue.remove(min);
                    }
                }
            }
        }

        if (minQueue.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{maxQueue.poll(), minQueue.poll()};
    }
}
