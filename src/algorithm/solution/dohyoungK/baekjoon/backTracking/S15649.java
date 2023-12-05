package algorithm.solution.dohyoungK.baekjoon.backTracking;

import algorithm.problem.baekjoon.backTracking.P15649;

import java.io.*;
import java.util.stream.IntStream;

public class S15649 implements P15649 {
// TODO:
//  자연수 N, M을 입력받아
//  1부터 N까지 자연수 중
//  중복 없이 M개를 고른 수열 찾기

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visited;
    static String[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] nums = IntStream.range(1, N + 1).toArray();
        visited = new boolean[N];
        sequence = new String[M];

        findSequence(nums, M, 0);

        bw.flush();
        bw.close();
    }

    private static void findSequence(int[] nums, int M, int index) throws IOException {
        if (index == M) {
            bw.write(String.join(" ", sequence) + "\n");
            return;
        }

        for (int num : nums) {
            if (!visited[num - 1]) {
                visited[num - 1] = true;
                sequence[index] = String.valueOf(num);
                findSequence(nums, M, index + 1);
                visited[num - 1] = false;
            }
        }
    }
}
