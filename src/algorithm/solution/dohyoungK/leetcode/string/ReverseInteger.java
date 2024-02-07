package algorithm.solution.dohyoungK.leetcode.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        boolean negChk = false;
        if (x < 0) {
            negChk = true;
            x *= -1;
        }

        String str = String.valueOf(x);
        List<String> list = Arrays.stream(str.split(""))
                .collect(Collectors.toList());
        Collections.reverse(list);
        str = String.join("", list);

        try { // 입력된 수의 reverse가 int를 넘어서면 return 0
            x = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }

        if (negChk) {
            x *= -1;
        }

        return x;
    }
}
