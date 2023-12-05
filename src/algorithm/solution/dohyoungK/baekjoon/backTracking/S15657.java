package algorithm.solution.dohyoungK.baekjoon.backTracking;

import algorithm.problem.baekjoon.backTracking.P15657;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class S15657 implements P15657 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int M;
    static int[] nums;
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
