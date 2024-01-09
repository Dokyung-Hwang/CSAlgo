package algorithm.solution.smileDK.baejoon.greedy;

import algorithm.problem.baekjoon.greedy.P11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S11399 implements P11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] people = new int[n];

        for (int i = 0 ; i < n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(people);

        int prev = 0;       // 이전 까지의 대기 시간 누적합
        int sum = 0;    // 대기 시간 총합

        for (int i = 0; i < n; i++) {
            sum += prev + people[i];
            prev += people[i];
        }

        System.out.println(sum);

    }
}
