package algorithm.solution.dohyoungK.programmers.bruteForce;

import algorithm.problem.programmers.bruteForce.P5;

public class S5 implements P5 {
    public static void main(String[] args) {
        System.out.println(solution(80, new int[][]{{80,20}, {50,40}, {30,10}}));
    }

// TODO:
//  유저의 현재 피로도와 여러 던전들의 [최소 필요 피로도, 소모 피로도]를 입력받아
//  유저가 최대 몇 개 던전을 탐험할 수 있는지 리턴

// TODO:
//  dfs로 조건에 맞는(현재 피로도가 최소 필요 피로도보다 클 때)
//  모든 던전 경로를 구해서 탐험 가능한 최대 던전 수 리턴

    static boolean[] visited;
    static int result = 0;

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(dungeons, 0, k);

        return result;
    }

    public static void dfs(int[][] dungeons, int cnt, int k) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, cnt + 1, k - dungeons[i][1]);
                visited[i] = false;
            }
        }

        result = Math.max(result, cnt);
    }
}
