package algorithm.solution.smileDK.programmers.basic;

import java.util.Arrays;

public class BiggestNumber {
    // https://school.programmers.co.kr/learn/courses/30/lessons/120899
    public static void main(String[] args) {
        BiggestNumber biggestNumber = new BiggestNumber();
        System.out.println(Arrays.toString(biggestNumber.solution(new int[]{1,8,3})));
        System.out.println(Arrays.toString(biggestNumber.solution(new int[]{9,10,11,8})));
    }

    public int[] solution(int[] array) {
        int max = array[0];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i;
            }
        }

        return new int[]{max, index};
    }
}
