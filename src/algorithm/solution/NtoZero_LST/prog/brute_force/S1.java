package algorithm.solution.NtoZero_LST.prog.brute_force;

import algorithm.problem.programmers.bruteForce.P1;

public class S1 implements P1 {
    /*
        sizes의 길이 1<=사이즈<=10^5 , 시간 복잡도 O(NlogN) 이하 권장
        문제 풀이 : 주어진 x, y 값이 가장 최소인 경우의 수를 찾아야 한다.
                  단, x, y 값이 뒤바뀔 수 있다.
     */
    public static void main(String[] args) {

    }

    public int solution(int[][] sizes) {
        int length = sizes.length;
        int x = 0;
        int y = 0;

        // 명함 길이가 긴 것 중 가장 큰 값과 , 짧은 것 중 가장 큰 값 구하기
        for(int i=0; i<length; i++) {
            int k = sizes[i][0];
            int l = sizes[i][1];

            // k, l 중 큰 수를 0번째 요소에, 작은 수를 1번째 요소에 배치
            sizes[i][0] = Math.max(k, l);
            sizes[i][1] = Math.min(k, l);

            // 최댓값으로 x, y를 찾아주기
            x = Math.max(x, sizes[i][0]);
            y = Math.max(y, sizes[i][1]);

        }
        return x*y;
    }
}
