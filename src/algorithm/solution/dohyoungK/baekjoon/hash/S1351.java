package algorithm.solution.dohyoungK.baekjoon.hash;

import algorithm.problem.baekjoon.hash.P1351;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S1351 implements P1351 {
// TODO: *
//  무한 수열에서 An을 구해 출력

// TODO:
//  일반적인 재귀를 사용하거나 시간, 메모리 초과
//  따라서 dp를 사용해야하고 N이 너무 크기 때문에
//  hashmap으로 중간 과정을 저장

    static long P;
    static long Q;
    static HashMap<Long, Long> dp = new HashMap<>(); // 이전에 계산한 적이 있는 값들 저장용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long N = Long.parseLong(input[0]);
        P = Long.parseLong(input[1]);
        Q = Long.parseLong(input[2]);

        dp.put(0L, 1L);

        System.out.println(findSequence(N));
    }

    public static long findSequence(long n) {
        // 이전에 계산한 적이 있다면 바로 return get()
        if (dp.getOrDefault(n, 0L) != 0L) {
            return dp.get(n);
        }

        // 아니라면 계산 후 hashmap에 저장하고 return get()
        dp.put(n, findSequence(n / P) + findSequence(n / Q));

        return dp.get(n);
    }
}
