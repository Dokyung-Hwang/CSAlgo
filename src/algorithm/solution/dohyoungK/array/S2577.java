package algorithm.solution.dohyoungK.array;

import algorithm.problem.array.P2577;

import java.util.Arrays;
import java.util.Scanner;

public class S2577 implements P2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        int[] result = new int[10];

        Arrays.stream(String.valueOf(num1 * num2 * num3).split(""))
                .map(Integer::parseInt)
                .forEach(num -> result[num] += 1);

        Arrays.stream(result)
                .forEach(System.out::println);
    }
}
