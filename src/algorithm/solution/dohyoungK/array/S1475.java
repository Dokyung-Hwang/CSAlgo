package algorithm.solution.dohyoungK.array;

import algorithm.problem.array.P1475;

import java.util.Arrays;
import java.util.Scanner;

public class S1475 implements P1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] digit = new int[10];

        Arrays.stream(String.valueOf(N).split(""))
                .map(Integer::parseInt)
                .forEach(num -> digit[num] += 1);
        digit[6] = (int) Math.ceil((digit[6] + digit[9]) / 2.0);
        digit[9] = 0;

        System.out.println(Arrays.stream(digit).max().getAsInt());
    }
}
