package algorithm.solution.dohyoungK.baekjoon.backTracking;

import algorithm.problem.baekjoon.backTracking.P6603;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class S6603 implements P6603 {
// Todo:
//  정수 k (집합 S의 원소 개수)와 집합 S를 입력받아
//  집합에서 6개의 수를 뽑는 모든 경우 출력

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int k;
    static int[] nums;
    static boolean[] visited;
    static Deque<String> lotto = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = br.readLine().split(" ");

            if (input[0].equals("0")) break;

            k = Integer.parseInt(input[0]);
            nums = IntStream.range(1, input.length)
                    .map(i -> Integer.parseInt(input[i]))
                    .toArray();
            visited = new boolean[k];

            findLotto(0);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    private static void findLotto(int index) throws IOException {
        if (lotto.size() == 6) {
            bw.write(String.join(" ", lotto) + "\n");
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                lotto.add(String.valueOf(nums[i]));
                findLotto(i + 1);
                lotto.pollLast();
                visited[i] = false;
            }
        }
    }
}
