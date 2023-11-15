package algorithm.solution.dohyoungK.baekjoon.backTracking;

import algorithm.problem.baekjoon.backTracking.P15652;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class S15652 implements P15652 {
// TODO:
//  자연수 N, M을 입력받아
//  1부터 N까지 자연수 중
//  M개를 고른 수열 찾기 (같은 수 허용, 수열의 중복은 X, 비내림차순 정렬)

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int M;
    static int[] nums;
    static Deque<String> sequence = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        nums = IntStream.range(1, N + 1).toArray();

        findSequence(0);

        bw.flush();
        bw.close();
    }

    private static void findSequence(int index) throws IOException {
        if (sequence.size() == M) {
            bw.write(String.join(" ", sequence) + "\n");
            return;
        }

        for (int i = index; i < nums.length; i++) {
            sequence.add(String.valueOf(nums[i]));
            findSequence(i);
            sequence.pollLast();
        }
    }
}
