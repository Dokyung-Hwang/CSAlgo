package algorithm.solution.dohyoungK.baekjoon.string;

import algorithm.problem.baekjoon.string.P3613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3613 implements P3613 {
// TODO:
//  c++과 Java의 변수명 형식대로 서로 바꿔 출력
//  둘 다 아니라면 Error! 출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder word = new StringBuilder(br.readLine());
        boolean upperCase = false;
        boolean underbar = false;

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                upperCase = true;
            } else if (word.charAt(i) == '_') {
                underbar = true;
            }
        }

        if (upperCase && underbar) { // 두 형식 모두 아닐 때
            System.out.println("Error!");
            return;
        } else if (upperCase) { // 자바 형식
            int index = 0;

            while (index < word.length()) {
                char ch = word.charAt(index);

                if (Character.isUpperCase(ch)) { // 대문자일 때
                    word.replace(index, index + 1, String.valueOf(Character.toLowerCase(ch)));
                    if (index != 0) {
                        word.insert(index, "_");
                        index++;
                    } else { // 자바 형식이면서 첫글자가 대문자일 때 error
                        System.out.println("Error!");
                        return;
                    }
                }
                index++;
            }
        } else if (underbar) { // c++ 형식
            int index = 0;

            while (true) {
                index = word.lastIndexOf("_");
                if (index == -1) break;
                if (index == 0 || index == word.length() - 1 || word.charAt(index - 1) == '_') {
                    System.out.println("Error!"); // c++ 형식이면서 첫글자나 마지막이 _일 때, _가 연속일 때
                    return;
                }

                char ch = word.charAt(index + 1);
                word.replace(index + 1, index + 2, String.valueOf(Character.toUpperCase(ch)));
                word.replace(index, index + 1, "");
            }
        }

        System.out.println(word);
    }
}
