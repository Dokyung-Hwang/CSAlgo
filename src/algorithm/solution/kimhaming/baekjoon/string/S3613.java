package algorithm.solution.kimhaming.baekjoon.string;

import algorithm.problem.baekjoon.string.P3613;
import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3613 implements P3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        // 시작이 대문자이거나 _, 마지막이 _ 불가
        if (str.charAt(0) <= '_' || str.charAt(str.length() - 1) == '_') {
            System.out.println("Error!");
            return;
        }

        // _ 불가 _A 불가 A_ 불가
        boolean upperCase = false;  // 만약 대문자가 있다면 C++ 로만 바꿀 수 있음
        boolean toJava = false; // false라면 C++, true라면 자바로 바꾸기
        char pre = str.charAt(0);   // 이전 문자 파악
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch <= 'Z') {
                if (toJava) {
                    System.out.println("Error!");
                    return;
                }
                upperCase = true;
            }

            if (ch == '_') {
                if (upperCase || pre == '_') {
                    System.out.println("Error!");
                    return;
                }
                toJava = true;
            }
            pre = ch;
        }

        if (toJava) {   // 자바로 바꿔야 함
            boolean nextUpper = false;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (nextUpper) {
                    sb.append(String.valueOf(ch).toUpperCase());
                    nextUpper = false;
                } else {
                    if (str.charAt(i) == '_') nextUpper = true;
                    else sb.append(ch);
                }
            }
        }
        else {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch <= 'Z') {
                    sb.append("_");
                    sb.append(String.valueOf(ch).toLowerCase());
                } else sb.append(ch);
            }
        }
        System.out.println(sb);
    }
}
