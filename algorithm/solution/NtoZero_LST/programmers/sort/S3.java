package algorithm.solution.NtoZero_LST.programmers.sort;

import java.util.Arrays;

public class S3 {
    /*
        논문 수 : 10^3, 논문별 인용 횟수 : 10^4
        h번 이상 인용된 요소가 h편 이상 있어야 한다.
        몇 번째로 많이 인용된 논문인지 찾기 위해 내림차순 정렬
    */
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int[] reversed = new int[citations.length];

        //인용 횟수 내림차순 정렬
        for(int i=0; i<citations.length; i++) {
            reversed[i] = citations[citations.length-1-i];
        }

        // h인덱스 변수 h
        int h = 0;

        //내림차순 정렬 배열 순회하면서 인용 횟수가 인덱스+1 이상인지 여부 판별
        for(int i=0; i<reversed.length; i++) {
            //인용 횟수가 i+1번째로 많은 경우와 해당 요소의 수가 맞물려야 한다.
            if(reversed[i]>=i+1) {
                h = i+1;
            } else break;
        }

        return h;
    }
}
