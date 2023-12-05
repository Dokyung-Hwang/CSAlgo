package algorithm.solution.dohyoungK.baekjoon.backTracking;

import algorithm.problem.baekjoon.backTracking.P1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1182 implements P1182 {
// TODO:
//  수열 내 정수의 개수를 나타내는 N과 정수 S, 그리고 수열이 주어질 때
//  그 부분수열의 합이 S가 되는 경우의 수 구하기

    static int result = 0;
    static int S;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[N];

        for (int i = 1; i <= N; i++) { // 부분 수열 원소 개수
            findSequence(0, i, 0);
        }

        System.out.println(result);
    }

    // 수열 시작 인덱스를 정해서
    // 배열에서 부분수열에 넣을 원소 개수가 충분한지 체크
    private static void findSequence(int sum, int cnt, int index) {
        if (cnt == 0 && sum == S) {
            result++;
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (!visited[i] && nums.length - i >= cnt) {
                visited[i] = true;
                findSequence(sum + nums[i], cnt - 1, i + 1);
                visited[i] = false;
            }
        }
    }
}