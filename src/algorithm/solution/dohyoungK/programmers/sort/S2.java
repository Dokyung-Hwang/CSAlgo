package algorithm.solution.dohyoungK.programmers.sort;

import algorithm.problem.programmers.sort.P2;

import java.util.Arrays;

public class S2 implements P2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 331, 33, 335, 351, 51, 9}));
    }

    public static String solution(int[] numbers) {
        String[] nums = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        StringBuilder result = new StringBuilder();

        Arrays.sort(nums, (o1, o2) -> {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb1.append(o1);
            sb1.append(o2);
            sb2.append(o2);
            sb2.append(o1);
            return sb2.toString().compareTo(sb1.toString());
        });

        if (nums[0].equals("0")) return "0";

        for (String n : nums) {
            result.append(n);
        }

        return result.toString();
    }
}
