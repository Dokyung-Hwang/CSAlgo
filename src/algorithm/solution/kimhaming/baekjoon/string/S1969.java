package algorithm.solution.kimhaming.baekjoon.string;

import algorithm.problem.baekjoon.string.P1969;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1969 implements P1969 {
    // https://velog.io/@haminggu/
    // Todo: 1. 문자열 str의 길이를 len에 저장하여 간략화하기
    // 2. count 0으로 초기화
    // 3. for문 돌면서 문자열을 한 문자씩 확인하기
    // 3-a. 현재 문자를 ch 가져와서
    // 3-b.
    // - ch가 c이고, 다음 문자가 = 또는 - 이면 i를 1 증가시킨다.
    // - ch가 d이고, 다음 문자가 - 이면 i를 1 증가시킨다.
    // - ch가 d이고, 다음 문자가 z 이며 그 다다음 문자가 = 이면 i를 2 증가시킨다.
    // - ch가 l 또는 n 이고, 다음 문자가 j 이면 i를 1 증가시킨다.
    // - ch가 s 또는 z 이고, 다음 문자가 = 이면 i를 1 증가시킨다.
    // count를 1 증가시킨다. -> count 출력
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int len = str.length();
        int count = 0;

        for (int i = 0; i < len; i++) {

            char ch = str.charAt(i);

            if (ch == 'c' && i < len - 1) {

                if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    i++;
                }

            }

            else if (ch == 'd' && i < len - 1) {
                if (str.charAt(i + 1) == '-') {
                    i++;
                }
                else if (str.charAt(i + 1) == 'z' && i < len - 2) {

                    if (str.charAt(i + 2) == '=') {
                        i += 2;
                    }
                }
            }

            else if ((ch == 'l' || ch == 'n') && i < len - 1) {
                if (str.charAt(i + 1) == 'j') {
                    i++;
                }
            }

            else if ((ch == 's' || ch == 'z') && i < len - 1) {
                if (str.charAt(i + 1) == '=') {
                    i++;
                }

            }

            count++;
        }

        System.out.println(count);
    }
}
