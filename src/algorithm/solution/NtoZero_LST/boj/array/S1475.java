//https://www.acmicpc.net/submit/1475

package algorithm.solution.NtoZero_LST.boj.array;


import algorithm.problem.baejoon.array.P1475;

import java.util.Scanner;

public class S1475 implements P1475 {
    /*
        N : 10^6 , 시간제한 - 2초
        시간 복잡도는 N 이하 이어야 함.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 방 번호
        int num = scan.nextInt();
        // 집계 배열
        int[] countArr = new int[10];
        // 반환할 정답
        int answer = 0;

        // num의 자릿수만큼 해당 수를 순회
        for(int i=0; i<String.valueOf(num).length(); i++) {
            // k는 해당 자릿수의 숫자
            int k = Integer.valueOf(String.valueOf(num).charAt(i)-'0');
            // 집계 배열의 해당 숫자 인덱스에서 개수를 계산
            countArr[k]++;
        }

        // 6 또는 9는 한 세트 당 두 번의 기회가 존재. 짝수면 나누고, 홀수면 하나 더 필요
        int sixAndNine = countArr[6]+countArr[9];
        sixAndNine =
                sixAndNine%2==0? sixAndNine/2 : sixAndNine/2+1;

        answer = sixAndNine;

        // sixAndNine 또는 countArr의 6,9 인덱스를 제외한 최대값을 비교해서 더 큰 숫자를 출력
        for(int i=0; i<countArr.length; i++) {
            if(i == 6 || i == 9) continue;
            answer = Math.max(answer, countArr[i]);
        }

        System.out.println(answer);
    }
}
