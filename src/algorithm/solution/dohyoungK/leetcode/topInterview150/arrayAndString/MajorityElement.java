package algorithm.solution.dohyoungK.leetcode.topInterview150.arrayAndString;

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = hm.getOrDefault(nums[i], 0);
            hm.put(nums[i], ++value);
        }

        int maxKey = 0;
        int maxValue = 0;
        for (int key : hm.keySet()) {
            int value = hm.get(key);
            if (value > maxValue) {
                maxKey = key;
                maxValue = value;
            }
        }

        return maxKey;
    }
}
