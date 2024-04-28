package algorithm.solution.smileDK.programmers.etc;

// https://school.programmers.co.kr/learn/courses/30/lessons/120825
public class RepeatedStrings {
    public static void main(String[] args) {
        System.out.println(solution("hello", 3));
    }

    public static String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);

            for (int j = 0; j < n; j++) {
                sb.append(c);
            };
        }

        return sb.toString();
    }
}
