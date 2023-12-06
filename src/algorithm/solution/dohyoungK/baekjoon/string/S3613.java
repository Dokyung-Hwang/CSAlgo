package algorithm.solution.dohyoungK.baekjoon.string;

import algorithm.problem.baekjoon.string.P3613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3613 implements P3613 {
// TODO:
//  c++과 Java의 변수명 형식대로 서로 바꿔 출력
//  둘 다 아니라면 Error! 출력

// TODO:
//  Error가 뜨는 경우

//  Java일 때
//  1. 글자에 _ 가 포함되어 있을 때
//  2. 문자열의 첫 글자가 대문자일 때
//
//  C++일 때
//  3. 글자에 대문자가 포함되어 있을 때
//  4. 문자열의 첫 글자나 마지막 글자가 _ 일 때
//  5. _ 가 연속으로 여러개 있을 때

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder word = new StringBuilder(br.readLine());
        boolean upperCase = false;
        boolean underbar = false;

        // 모든 글자를 돌면서 대문자가 있는지, _ 가 존재하는 지 확인
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                upperCase = true;
            } else if (word.charAt(i) == '_') {
                underbar = true;
            }
        }

        // 1, 3
        // 두 형식 모두 아닐 때
        if (upperCase && underbar) {
            System.out.println("Error!");
            return;
        }

        if (upperCase) { // 자바 형식
            if (Character.isUpperCase(word.charAt(0))) { // 2. 첫 글자가 대문자일 때
                System.out.println("Error!");
                return;
            }

            int index = 1;
            while (index < word.length()) {
                char ch = word.charAt(index);

                if (Character.isUpperCase(ch)) { // 대문자일 때
                    // 대문자를 소문자로 치환
                    word.replace(index, index + 1, String.valueOf(Character.toLowerCase(ch)));
                    // 대문자 자리 앞에 _ 추가
                    word.insert(index, "_");
                    index++;
                }
                index++;
            }
        } else if (underbar) { // c++ 형식
            while (true) {
                int index = word.lastIndexOf("_");
                // _ 가 없으면 끝
                if (index == -1) break;
                // 4, 5
                // 첫글자가 _ 일 때, 마지막 글자가 _ 일 때, _ 가 연속으로 존재할 때
                if (index == 0 || index == word.length() - 1 || word.charAt(index - 1) == '_') {
                    System.out.println("Error!");
                    return;
                }

                char ch = word.charAt(index + 1);
                // _ 다음 자리 글자를 대문자로 치환
                word.replace(index + 1, index + 2, String.valueOf(Character.toUpperCase(ch)));
                // _ 를 삭제
                word.replace(index, index + 1, "");
            }
        }

        System.out.println(word);
    }
}
