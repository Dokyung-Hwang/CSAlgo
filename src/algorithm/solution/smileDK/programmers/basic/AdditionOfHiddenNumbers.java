package algorithm.solution.smileDK.programmers.basic;

public class AdditionOfHiddenNumbers {
    // https://school.programmers.co.kr/learn/courses/30/lessons/120851
    public static void main(String[] args) {
        System.out.println(solution("aAb1B2cC34oOp"));
        System.out.println(solution("1a2b3c4d123"));
    }

    public static int solution(String my_string) {
        int sum = 0;

        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
            }
        }
        return sum;
    }
}
