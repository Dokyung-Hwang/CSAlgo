package algorithm.solution.smileDK.baejoon.string;

import algorithm.problem.baekjoon.string.P1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Todo:
*  sol.
*   1. BufferedReader 입력 받기
*   2. target 문자열 삭제 하기 전 document 길이 변수에 저장하기
*   3. document에서 target 문자열을 String.replace를 이용하여 삭제
*   4. 원본 document의 길이 - target 문자열이 삭제된 document의 길이 / target 문자열의 길이
* */


public class S1543 implements P1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String keyword = br.readLine();

        int documentLength = document.length();


        document = document.replace(keyword, "");

        System.out.println((documentLength - document.length()) / keyword.length());

    }
}
