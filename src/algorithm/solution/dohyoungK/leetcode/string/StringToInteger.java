package algorithm.solution.dohyoungK.leetcode.string;

public class StringToInteger {
// TODO: 조건 (반례가 다 나와서 다행이네ㅎㅎ)
//  1. 글자나 숫자, 기호가 나오기 전의 공백은 무시
//  2. 글자, 숫자, 기호 이후의 공백이나 글자가 나온다면 break (그 전까지의 숫자만 변환)

    public static void main(String[] args) {
        String s = "+-987";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        boolean letterChk = false;
        boolean negChk = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (letterChk) break;
                continue;
            }
            if (c == '+') {
                if (letterChk) break;
                letterChk = true;
                continue;
            }
            if (c == '-') {
                if (letterChk) break;
                negChk = true;
                letterChk = true;
                continue;
            }

            if (Character.isDigit(c)) {
                letterChk = true;
                sb.append(c);
            }
            else break;
        }

        if (sb.length() == 0) return 0;

        int result = 0;
        try {
            result = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            if (negChk) return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }

        if (negChk) return result * -1;
        return result;
    }
}
