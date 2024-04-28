package algorithm.solution.smileDK.programmers.toss;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    public static int solution(int[] levels) {
        if (levels.length < 4) return -1;

        int topNum = levels.length/4;

        Arrays.sort(levels);

        return levels[levels.length - topNum];

    }


    // 예준님 풀이
//    public static int solution(int[] levels) {
//        if (levels.length < 4) return -1;
//
//        Arrays.sort(levels);
//
//        int topNum = (int) Math.ceil(levels.length * 0.75);
//
//        if (topNum >= levels.length) return levels[levels.length - 1];
//
//        return levels[topNum];
//    }
}
