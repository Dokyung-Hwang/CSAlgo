package algorithm.solution.dohyoungK.baekjoon.deque;

import algorithm.problem.baejoon.deque.P1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class S1021 implements P1021 {
// TODO:
//  큐의 크기 N과 뽑아내려는 수의 개수 M을 입력받고
//  M개의 순서대로 수를 뽑아낼 때
//  2,3번 연산의 최솟값 출력
//  (2번 연산: 맨 앞 빼서 맨 뒤로)
//  (3번 연산: 맨 뒤 빼서 맨 앞으로)

// TODO:
//  큐에서 뺄 숫자가 첫번째로 올 때까지
//  2번 연산을 하면서
//  2번 연산을 수행했을 때와 3번 연산을 수행했을 때 중
//  적은 횟수를 선택

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().split(" ")[0]);
        String[] nums = br.readLine().split(" ");
        Deque<Integer> deque = IntStream.range(1, N + 1).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        int index = 0; // nums의 index
        int cnt = 0;
        int result = 0;

        while (index < nums.length) {
            if (Integer.parseInt(nums[index]) == deque.peekFirst()) {
                deque.pollFirst();
                index++;
                result += Math.min(cnt, N - cnt);
                N--;
                cnt = 0;
            }

            if (deque.isEmpty()) {
                break;
            }

            deque.add(deque.pollFirst());
            cnt++;
        }

        System.out.println(result);
    }
}
