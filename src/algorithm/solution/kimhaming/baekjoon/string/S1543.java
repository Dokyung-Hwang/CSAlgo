package algorithm.solution.kimhaming.baekjoon.string;

import algorithm.problem.baekjoon.string.P1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1543 implements P1543 {
        // https://velog.io/@haminggu/백준Java-1543번-문서-검색-문자열
        // Todo: 인덱스 0부터 n-1 까지 하나의 반복문을 돌 때, 갯수 찾기 ? (X)
        //  1. S에서 모든 S2를 제거하기
        //  2. 제거된 후의 S의 길이 구하기
        //  3. 문자열 S의 길이에서 문자열 S2의 길이를 나눈다.

        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String S2 = br.readLine();

        // 문자열 S의 길이 재기
        int size = S.length();
        int size2 = S2.length();

        // 문자열 S에서 문자열 S2 찾아서 "" 로 바꾸기 즉, 제거하기 !
        S = S.replace(S2, "");
        // 원래 문자열의 길이에서 갱신된 문자열의 길이를 빼고, 문자열 S2의 길이로 나누어 중복 없이 등장하는 횟수를 구한다.
            int count = ((size - S.length()) / size2);
            System.out.println(count);
    }
 }
