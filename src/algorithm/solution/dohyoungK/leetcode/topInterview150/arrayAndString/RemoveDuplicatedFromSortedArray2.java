package algorithm.solution.dohyoungK.leetcode.topInterview150.arrayAndString;

import java.util.*;

public class RemoveDuplicatedFromSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> hm = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = hm.getOrDefault(nums[i], 0);
            hm.put(nums[i], ++value);
        }

        int index = 0;
        for (int key : hm.keySet()) {
            if (hm.get(key) >= 2) {
                nums[index++] = key;
            }

            nums[index++] = key;
        }

        return index;
    }
}
