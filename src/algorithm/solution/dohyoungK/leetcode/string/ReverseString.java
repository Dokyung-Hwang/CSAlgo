package algorithm.solution.dohyoungK.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseString {

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }

    public static void reverseString(char[] s) {
        String str = new String(s);
        List<String> list = Arrays.stream(str.split(""))
                .collect(Collectors.toList());
        Collections.reverse(list);

        str = String.join("", list);
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            s[i] = arr[i];
        }

        System.out.println(Arrays.toString(s));
    }
}
