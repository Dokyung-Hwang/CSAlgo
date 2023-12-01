package algorithm.solution.dohyoungK.baekjoon.string;

import algorithm.problem.baekjoon.string.P1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1543 implements P1543 {
// TODO:
//  영어로만 이루어진 문서제목에서
//  어떤 단어가 중복되지 않고 몇 번 등장하는지 출력

// TODO:
//  indexOf(string str, int fromIndex)를 사용해 fromIndex를 증가시키면서
//  단어 등장 횟수 세기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder title = new StringBuilder(br.readLine());
        String word = br.readLine();
        int index = 0;
        int result = 0;

        while (index < title.length()) {
            index = title.indexOf(word, index);
            if (index == -1) break;
            else index += word.length();
            result++;
        }

        System.out.println(result);
    }
}
