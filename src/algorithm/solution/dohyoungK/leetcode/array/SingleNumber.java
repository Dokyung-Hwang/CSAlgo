package algorithm.solution.dohyoungK.leetcode.array;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                if (nums[i + 1] == nums[i + 2]) {
                    return nums[i];
                } else {
                    return nums[i + 1];
                }
            }
        }

        return nums[nums.length - 1];
    }
}
