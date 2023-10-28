package algorithm.solution.NtoZero_LST.prog.brute_force;

import algorithm.problem.programmers.bruteForce.P5;

public class S5 implements P5 {
    /*
        유저의 현재 피로도 : k <= 5000
        행의 길이 <= 8 (최대 던전 수)
        최소 필요 피로도[i][0], 소모 피로도[i][1]는 1~1000
    */

    static boolean[] visited;
    static int max;

    public int solution(int k, int[][] dungeons) {
        // 방문 했는지 여부를 가리는 boolean 배열
        visited = new boolean[dungeons.length];
        // 재귀
        counting(k, dungeons, 0);
        return max;
    }
    // 던전 탐험 횟수 추가
    static void counting(int k, int[][] dungeons, int count) {
        for(int i=0; i<dungeons.length; i++) {
            int minRequired = dungeons[i][0]; // 최소 피로도
            int consumed = dungeons[i][1]; // 소모 피로도

            // 방문 여부 또는 최소피로도 여부 확인
            if (visited[i]== true || minRequired > k) {
                continue;
            }

            // 방문 확인
            visited[i] = true;
            counting(k-consumed, dungeons, count+1);
            // 다른 케이스 확인 위해 방문처리 취소
            visited[i] = false;
        }
        max = Math.max(max, count);
    }
}
