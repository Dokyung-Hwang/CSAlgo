package algorithm.solution.dohyoungK.programmers.hash;

import algorithm.problem.programmers.hash.P3;

import java.util.*;
import java.util.stream.Collectors;

public class S3 implements P3 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
    }

    public static boolean solution(String[] phone_book) {
        if (phone_book.length == 1) {
            return true;
        }

        Set<String> hs = new HashSet<>(Arrays.asList(phone_book));
        for (String phone : phone_book) {
            for (int i = 0; i < phone.length(); i++) {
                if (hs.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}
