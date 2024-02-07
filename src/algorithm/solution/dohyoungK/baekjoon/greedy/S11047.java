package algorithm.solution.dohyoungK.baekjoon.greedy;

import algorithm.problem.baekjoon.greedy.P11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class S11047 implements P11047 {
// TODO: N종류의 동전을 사용해 가치의 합을 K로 만들 때
//  필요한 최소 동전 개수 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> coins = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            coins.addFirst(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (!coins.isEmpty()) {
            int coin = coins.pop();

            if (K == 0) break;
            if (K < coin) continue;

            result += K / coin;
            K %= coin;
        }

        System.out.println(result);
    }
}
