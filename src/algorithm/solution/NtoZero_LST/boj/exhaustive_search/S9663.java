package algorithm.solution.NtoZero_LST.boj.exhaustive_search;

import algorithm.problem.baekjoon.backTracking.P9663;

public class S9663 implements P9663 {
    static boolean[] isUsed1; // Column 차지 여부
    static boolean[] isUsed2; // 역방향 대각선
    static boolean[] isUsed3; // 정방향 대각선
    static int count = 0;
    static int n;

    public static void main(String[] args) {

    }

    public static void func(int cur) { // cur번째 행에 말을 배치
        if (cur == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isUsed1[i] || isUsed2[i + cur] || isUsed3[cur - i + n - 1]) {
                continue;
            }

//            isUsed1[i] = true;
//            isUsed2[i + cur] = true;
//            isUsed3[cur - i + n - 1] = true;
//
//            func(cur + 1);
//
//            isUsed1[i] = false;
//            isUsed2[i + cur] = false;
//            isUsed3[cur - i + n - 1] = false;
        }
    }
}
