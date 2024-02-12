package algorithm.solution.dohyoungK.leetcode.topInterview150.arrayAndString;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int index = 0; // 진짜 값을 담을 index

        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }
}
