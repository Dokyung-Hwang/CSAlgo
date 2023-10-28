package algorithm.solution.dohyoungK.baekjoon.queue;

import algorithm.problem.baekjoon.queue.P2164;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class S2164 implements P2164 {
// TODO:
//  정수 N을 입력받아 공식대로 카드를 버리고 섞을 때
//  마지막으로 남게되는 숫자 출력

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<Integer> deque = IntStream.range(1, N + 1).boxed().collect(Collectors.toCollection(ArrayDeque::new));

        while (deque.size() > 1) {
            deque.pollFirst();
            deque.add(deque.pollFirst());
        }

        System.out.println(deque.peekFirst());
    }
}
