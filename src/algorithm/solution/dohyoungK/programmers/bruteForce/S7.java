package algorithm.solution.dohyoungK.programmers.bruteForce;

import algorithm.problem.programmers.bruteForce.P7;

import java.util.Arrays;
import java.util.List;

public class S7 implements P7 {
    public static void main(String[] args) {
        System.out.println(solution("AAA"));
    }

// TODO:
//  모음사전 A,E,I,O,U를 오름차순 순서로 나열했을 때
//  입력받은 word가 몇번째 순서인지 리턴


// TODO:
//  dfs로 모음사전을 돌리면서 cnt를 증가시키면서
//  word와 dfs의 결과가 동일해지면 재귀 끝내고 cnt 리턴

    static List<String> vowels = Arrays.asList("A", "E", "I", "O", "U");
    static int cnt = 0;
    static int result = -1;

    public static int solution(String word) {
        dfs(word, "");

        return result;
    }

    public static void dfs(String input, String word) {
        if (word.equals(input)) result = cnt;
        if (word.length() == 5 || result != -1) return;

        for (String s : vowels) {
            StringBuilder sb = new StringBuilder(word);
            sb.append(s);
            cnt++;

            dfs(input, sb.toString());
        }
    }
}
