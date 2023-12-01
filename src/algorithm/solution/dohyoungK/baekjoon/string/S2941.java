package algorithm.solution.dohyoungK.baekjoon.string;

import algorithm.problem.baekjoon.string.P2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2941 implements P2941 {
// TODO:
//  입력받은 문자열 중 크로아티아 알파벳이 몇 개 있는지 출력

// TODO:
//  특수 크로아티아 알파벳을 "#"으로 replace한 뒤
//  마지막으로 word의 length를 세면
//  일반 알파벳 개수 + 특수 알파벳 개수가 나옴

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder word = new StringBuilder(br.readLine());
        String[] croatiaAlpha = new String[] {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};

        for (String alpha : croatiaAlpha) {
            int index = 0;

            while (index < word.length()) {
                index = word.indexOf(alpha, index);
                if (index != -1) {
                    word.replace(index, index + alpha.length(), "#");
                    index++;
                } else break;
            }
        }

        System.out.println(word.length());
    }
}
