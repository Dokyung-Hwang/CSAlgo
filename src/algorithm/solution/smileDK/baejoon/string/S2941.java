package algorithm.solution.smileDK.baejoon.string;

import algorithm.problem.baekjoon.string.P2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*Todo:
*  sol.
*  1. BufferedReader 입력 받기
*  2. 일반 문자, 크로아티아 문자열의 갯수를 셀 count 변수 선언
*  3. if 문 분기, 일반 문자 체크 후 카운팅
*  add) 안쪽 if 문에서 str.charAt(i + 1) 접근 전에 런타임 에러 (StringIndexOutOfBounds) 방지 하기 위해 바깥쪽 조건문에서 인덱스 검사
* */

public class S2941 implements P2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // "c=" || c-
            if(c == 'c' && i < str.length() - 1) {
                if(str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    i++;
                }
            }

            // "d-" || "dz="
            if (c == 'd' && i < str.length() - 1) {
                if (str.charAt(i + 1) == '-') {
                    i++;
                }
                else if (str.charAt(i + 1) == 'z' && i < str.length() - 2) {
                    if (str.charAt(i + 2) == '=') {
                        i += 2;
                    }
                }
            }

            // "lj" || "nj"
            if ((c == 'l' || c == 'n') && i < str.length() - 1) {
                if (str.charAt(i + 1) == 'j') {
                    i++;
                }
            }

            // "s=" || "z="
            if ((c == 's' || c == 'z') && i < str.length() - 1) {
                if (str.charAt(i + 1) == '=') {
                    i++;
                }
            }

            count++;
        }

        System.out.println(count);
    }
}
