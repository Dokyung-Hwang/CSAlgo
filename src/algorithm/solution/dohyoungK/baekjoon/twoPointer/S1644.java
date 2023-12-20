package algorithm.solution.dohyoungK.baekjoon.twoPointer;

import algorithm.problem.baekjoon.twoPointer.P1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class S1644 implements P1644 {
// TODO:
//  자연수 N을 입력받아
//  연속된 소수의 합으로 나타낼 수 있는 모든 경우의 수 출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        Deque<Integer> primes = new ArrayDeque<>();

        int count = 0;
        int sum = 0;
        int end = 2;

        do {
            while (end <= N && sum < N) {
                if (isPrime(end)) {
                    primes.add(end);
                    sum += end;
                }
                end++;
            }

            if (sum == N) {
                count++;
            }
            sum -= primes.pollFirst();
        } while (!primes.isEmpty());

        System.out.println(count);
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
