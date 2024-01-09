package algorithm.solution.smileDK.baejoon.greedy;

import algorithm.problem.baekjoon.greedy.P2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2217 implements P2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] weight = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(weight);

        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, weight[i] * (n - i));
        }

        System.out.println(answer);
    }
}
