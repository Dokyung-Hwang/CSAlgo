package algorithm.solution.dohyoungK.programmers.bruteForce;

import algorithm.problem.programmers.bruteForce.P7;

import java.util.Arrays;
import java.util.List;

public class S7 implements P7 {
    public static void main(String[] args) {
        System.out.println(solution("AAA"));
    }

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
