package algorithm.solution.dohyoungK.baekjoon.string;

import algorithm.problem.baekjoon.string.P9996;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class S9996 implements P9996 {
// TODO:
//  패턴과 파일 이름이 주어질 때
//  각각의 파일 이름이 패턴과 일치하는지 아닌지 출력

// TODO:
//  입력받은 패턴을 정규식 패턴으로 구성하고
//  파일이름이 패턴과 일치하는지 아닌지 확인

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("[*]");
        String pattern = "^" + input[0] + "[a-z]*" + input[1] + "$";

        for (int i = 0; i < N; i++) {
            if (Pattern.matches(pattern, br.readLine())) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
