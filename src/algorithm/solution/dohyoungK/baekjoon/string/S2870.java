package algorithm.solution.dohyoungK.baekjoon.string;

import algorithm.problem.baekjoon.string.P2870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;

public class S2870 implements P2870 {
// TODO: 숫자와 알파벳 소문자로 이루어진 문자열에서
//  문자열 사이 숫자를 오름차순 정렬해 출력

// TODO: 100자리는 long보다 크므로 BigInteger로 변환
//  숫자 시작 인덱스랑 숫자가 알파벳 이전에 존재하는 지를 체크해서
//  최소 힙에 숫자를 넣어 자동 정렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<BigInteger> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringBuilder str = new StringBuilder(br.readLine());
            int numStartIdx = 0; // 숫자 시작 인덱스
            boolean beforeNum = false; // 현재 인덱스 이전에 숫자가 있는지

            for (int j = 0; j < str.length(); j++) {
                if (Character.isAlphabetic(str.charAt(j))) {
                    if (beforeNum) {
                        minHeap.add(new BigInteger(str.substring(numStartIdx, j)));
                        beforeNum = false;
                    }
                } else {
                    if (!beforeNum) {
                        numStartIdx = j;
                    }
                    beforeNum = true;
                }
            }

            if (beforeNum) { // 마지막 자리가 숫자로 끝나면 숫자를 따로 추가
                minHeap.add(new BigInteger(str.substring(numStartIdx, str.length())));
            }
        }

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }
}
