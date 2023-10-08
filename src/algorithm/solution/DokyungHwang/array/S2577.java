package algorithm.solution.DokyungHwang.array;

import algorithm.problem.array.P2577;

import java.util.Scanner;


/*
* Input: 3개의 자연수 A, B, C
* Output: A * B * C의 1~9까지의 숫의 갯수
*
* S.
* 아스키 코드 활용 - charAt(i) - 48('0')
* */

public class S2577 implements P2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt() * sc.nextInt() * sc.nextInt();
        sc.close();
        String valueToString = Integer.toString(value);
        int[] countArr = new int[10];

        for (int i = 0; i < valueToString.length(); i++) {
            char c = valueToString.charAt(i);
            countArr[c - 48]++;
        }


        // output
        for (int j : countArr) {
            System.out.println(j);
        }
    }
}
