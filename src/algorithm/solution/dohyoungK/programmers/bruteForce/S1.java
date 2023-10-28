package algorithm.solution.dohyoungK.programmers.bruteForce;

import algorithm.problem.programmers.bruteForce.P1;

public class S1 implements P1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{60, 50}, {30,70}, {60,30}, {80,40}}));
    }

// TODO:
//  명함의 가로 세로 길이를 입력받아
//  모든 명함들을 담을 수 있는 가장 작은 지갑 사이즈 출력

// TODO:
//  가로 세로 둘 중에 긴 것들 중 최댓값 찾고,
//  작은 것들 중 최댓값 찾아서 곱하기

    public static int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);
            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }

        return maxWidth * maxHeight;
    }
}
