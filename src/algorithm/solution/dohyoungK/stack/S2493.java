package algorithm.solution.dohyoungK.stack;

import algorithm.problem.stack.P2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 다른 풀이들보다 오래 걸림, 풀이 찾아보기
public class S2493 implements P2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] towers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] result = new int[N];
        Deque<Tower> deque = new ArrayDeque<>();
        deque.add(new Tower(towers[N - 1], N - 1));
        for (int i = N - 2; i >= 0; i--) {
            while (!deque.isEmpty()) {
                if (towers[i] >= deque.peekLast().tower) {
                    result[deque.pollLast().index] = i + 1;
                } else {
                    deque.add(new Tower(towers[i], i));
                    break;
                }
            }

            if (deque.isEmpty()) {
                deque.add(new Tower(towers[i], i));
            }
        }

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static class Tower {
        private int tower;
        private int index;

        public Tower(int tower, int index) {
            this.tower = tower;
            this.index = index;
        }
    }
}
