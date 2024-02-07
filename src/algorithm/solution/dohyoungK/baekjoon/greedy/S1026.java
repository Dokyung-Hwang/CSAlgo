package algorithm.solution.dohyoungK.baekjoon.greedy;

import algorithm.problem.baekjoon.greedy.P1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S1026 implements P1026 {
// TODO: 배열 A를 재배열 해서
//  A[0] x B[0] + ... A[i] x B[i] + ... 의 최소 합 찾기

// TODO: B 배열의 큰 값과 A 배열의 작은 값으로 쌍을 맞추기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        Pair[] B = new Pair[N];
        for (int i = 0; i < N; i++) {
            B[i] = new Pair(i, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(A);
        Arrays.sort(B, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.value > o2.value) return -1;

                return 1;
            }
        });

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i] * B[i].value;
        }

        System.out.println(sum);
    }

    public static class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
