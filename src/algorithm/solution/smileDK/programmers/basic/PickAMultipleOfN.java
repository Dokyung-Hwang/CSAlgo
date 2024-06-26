package algorithm.solution.smileDK.programmers.basic;

import java.util.ArrayList;
import java.util.Arrays;

public class PickAMultipleOfN {
    // https://school.programmers.co.kr/learn/courses/30/lessons/120905
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12})));
    }

    public static int[] solution(int n, int[] numList) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < numList.length; i++) {
            if (numList[i] % n == 0) {
                arrayList.add(numList[i]);
            }
        }

        Integer[] temp = arrayList.toArray(new Integer[arrayList.size()]);
        return Arrays.stream(temp).mapToInt(Integer::intValue).toArray();
    }
}
