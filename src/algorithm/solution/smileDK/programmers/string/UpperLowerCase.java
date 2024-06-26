package algorithm.solution.smileDK.programmers.string;

public class UpperLowerCase {
    // https://school.programmers.co.kr/learn/courses/30/lessons/120893
    public static void main(String[] args) {
        System.out.println(solution("cccCCC"));
        System.out.println(solution("abCdEfghIJ"));
    }

    public static String solution(String my_string) {
        StringBuilder sb = new StringBuilder();

        for (char c : my_string.toCharArray()) {
            if (Character.isUpperCase(c))
                sb.append(Character.toLowerCase(c));
            else
                sb.append(Character.toUpperCase(c));
        }

        return sb.toString();
    }
}
