package algorithm.solution.smileDK.baejoon.string;

import algorithm.problem.baekjoon.string.P3613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/* Memo.
*   C++ 문법
*   1. 맨 뒷 문자가 '_' 이면 에러
*   2. 맨 앞 문자가 '_' 이면 에러
*   3. '__' 언더바가 연속으로 두 개이상이면 에러
*   Java 문법
*   1. 제일 앞에 문자가 대문자이면 에러
*   2. 대문자와 '_'가 혼합이면 에러
*   논외(정상)
*   1. 소문자만 입력될 경우(CPP -> JAVA)
*   2. 대문자 연속일 경우
*   백준 질문 게시판 반례 정리(https://www.acmicpc.net/board/view/92676)
*   맨 뒤 문자가 '_' 이면 에러
    asd_
    Error!
    //맨 앞 문자가 '_' 이면 에러
    _asd
    Error!
    //'_' 연속 두개면 에러
    as__asd
    Error!
    //맨 앞 문자가 대문자면 에러
    Aasd
    Error!
    //대문자와 '_'가 혼종이면 에러
    asdAasd_asd
    Error!
    //소문자만 입력 될 경우 정상
    fadfadfadsf
    fadfadfadsf
    // 대문자 연속일 경우 정상
    asdasdASDASD
    asdasd_a_s_d_a_s_d
* */


public class S3613 implements P3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder varName = new StringBuilder(br.readLine());

        boolean java = false;
        boolean cpp = false;

        // C++ 1, 2번 조건 & Java 1번 조건
        // 아스키 코드 변환: '_' - 95, 대문자 - 65 ~ 90
        if (varName.toString().startsWith("_") || varName.toString().endsWith("_")) {
            System.out.println("Error!");
            return;
        }

        // 논외 1번
        if (varName.toString().equals(varName.toString().toLowerCase())) {
            cpp = true;
        }


        // long_and_mnemonic_identifier || longAndMnemonicIdentifier
        for (int i = 0; i < varName.length(); i++) {
            char c = varName.charAt(i);

            if (Character.isUpperCase(c)) {
                java = true;
            }
            else if (c == '_') {
                cpp = true;
            }

            // C++ 3번 조건
            if (c == '_' && i < varName.length() - 1) {
                if (varName.charAt(i + 1) == '_') {
                    System.out.println("Error!");
                    return;
                }
            }
        }

        if (java && cpp){
            System.out.println("Error!");
            return;
        }
        else if (java) {
            int index = 0;

            while(index < varName.length()) {
                char c = varName.charAt(index);

                if (Character.isUpperCase(c)) {
                    varName.replace(index, index + 1, String.valueOf(Character.toLowerCase(c)));
                    if (index != 0) {
                        varName.insert(index, "_");
                        index++;
                    } else {
                        System.out.println("Error!");
                        return;
                    }
                }
                index++;
            }
        }
        else if (cpp) {
             int index = 0;

             while(true) {
                 index = varName.lastIndexOf("_");
                 if (index == -1) break;
                 if (index == 0 || index == varName.length() - 1 || varName.charAt(index - 1) == '_') {
                     System.out.println("Error!");
                     return;
                 }

                 char c = varName.charAt(index + 1);
                 varName.replace(index + 1, index + 2, String.valueOf(Character.toUpperCase(c)));
                 varName.replace(index, index + 1, "");
             }

        }
        else {
            System.out.println("Error!");
        }

        System.out.println(varName);
    }
}
