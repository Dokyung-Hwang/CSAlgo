package algorithm.solution.dohyoungK.array;

import algorithm.problem.array.P10808;

import java.util.Arrays;
import java.util.Scanner;

public class S10808 implements P10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int[] result = new int[26];

        for (char c: word.toCharArray()) {
            result[c - 'a'] += 1;
        }

        Arrays.stream(result)
                .forEach(num -> System.out.print(num + " "));
    }
}
