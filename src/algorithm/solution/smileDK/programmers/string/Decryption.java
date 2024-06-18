package algorithm.solution.smileDK.programmers.string;

public class Decryption {
    // https://school.programmers.co.kr/learn/courses/30/lessons/120892
    public static void main(String[] args) {
        System.out.println(solution("dfjardstddetckdaccccdegk", 4));
        System.out.println(solution("pfqallllabwaoclk", 2));
    }

    public static String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        for (int i = code - 1; i < cipher.length(); i+=code) {
            sb.append(cipher.charAt(i));
        }

        return sb.toString();
    }
}
