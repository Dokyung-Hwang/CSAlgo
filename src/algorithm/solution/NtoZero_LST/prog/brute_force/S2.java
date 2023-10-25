package algorithm.solution.NtoZero_LST.prog.brute_force;

import algorithm.problem.programmers.bruteForce.P2;

import java.util.ArrayList;
import java.util.List;

public class S2 implements P2 {
    /*
        N<=10^5
        1번 수포자 : 1, 2, 3, 4, 5 ...
        2번 수포자 : 2, 1, 2, 3, 2, 4, 2, 5 ...
        3번 수포자 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
     */

    public int[] solution(int[] answers) {

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 맞힌 개수
        int count1 = countAns(arr1, answers);
        int count2 = countAns(arr2, answers);
        int count3 = countAns(arr3, answers);

        int maxCount = Math.max(count1, Math.max(count2, count3));

        List<Integer> ansList = new ArrayList<>();
        if (count1 == maxCount) {
            ansList.add(1);
        }
        if (count2 == maxCount) {
            ansList.add(2);
        }
        if (count3 == maxCount) {
            ansList.add(3);
        }

        // List를 int 배열로 변환
        int[] result = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            result[i] = ansList.get(i);
        }

        return result;
    }

    // 정답을 맞힌 개수를 구하는 함수 countAns
    public int countAns(int[] arr, int[] answers) {
        int k = 0;
        for(int i=0; i<answers.length; i++) {
            // 순환 숫자(rec) i번째를 arr.length와 비교 순환하는 나머지값이 인덱스
            int rec = i % arr.length;
            if(arr[rec] == answers[i]) k++;
        }
        return k;
    }
}
