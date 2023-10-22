package algorithm.solution.DokyungHwang.programmers.brute_force;

import algorithm.problem.programmers.brute_force.P1;

import java.util.Arrays;

public class S1 implements P1 {
    public static void main(String[] args) {
        int[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        int[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};


        System.out.println(solution(sizes1, 1));
        System.out.println(solution(sizes2, 1));
        System.out.println(solution(sizes3, 1));
    }

    public static int solution(int[][] sizes) {
        int answer;
        int[] longest = new int[sizes.length];
        int[] shortest = new int[sizes.length];

        //   [0] [1]
        // 0  6   5
        // 1  3   7
        // 2  6   3
        // 3  8   4
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] >= sizes[i][1]) {
                longest[i] += sizes[i][0];
                shortest[i] += sizes[i][1];
            }
            else {
                longest[i] += sizes[i][1];
                shortest[i] += sizes[i][0];
            }
        }
        Arrays.sort(longest);
        Arrays.sort(shortest);


        System.out.println(Arrays.toString(longest));
        System.out.println(Arrays.toString(shortest));

        answer = longest[sizes.length - 1] * shortest[sizes.length - 1];

        return answer;
    }

    public static int solution(int[][] sizes, int ref) {
        int width = 0;
        int height = 0;

        for (int[] card : sizes) {
            width = Math.max(width, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }

        return width * height;
    }
}
