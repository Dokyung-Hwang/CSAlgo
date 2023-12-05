package algorithm.solution.dohyoungK.baekjoon.backTracking;

import algorithm.problem.baekjoon.backTracking.P15654;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.IntStream;

public class S15654 implements P15654 {
// TODO:
//  자연수 N, M, N개의 수를 입력받아
//  N개의 수 중
//  M개를 고른 수열 찾기 (수열의 중복은 X, 비내림차순 정렬)

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int M;
    static int[] nums;
    static boolean[] visited;
    static Deque<String> sequence = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        visited = new boolean[N];

        findSequence();

        bw.flush();
        bw.close();
    }

    private static void findSequence() throws IOException {
        if (sequence.size() == M) {
            bw.write(String.join(" ", sequence) + "\n");
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence.add(String.valueOf(nums[i]));
                findSequence();
                sequence.pollLast();
                visited[i] = false;
            }
        }
    }
}
