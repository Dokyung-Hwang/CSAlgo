package algorithm.solution.smileDK.baejoon.solvedac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while(!(input=br.readLine()).equals("0")) {
            if (isPalindromeUseTwoPointer(input))
                sb.append("yes").append("\n");
            else
                sb.append("no").append("\n");
        }

        System.out.println(sb);
    }

    public static boolean isPalindromeUseTwoPointer(String str) {
        int start = 0;
        int end = str.length() - 1;

        while(start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }

    public static boolean isPalindromeUseReverseString(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
