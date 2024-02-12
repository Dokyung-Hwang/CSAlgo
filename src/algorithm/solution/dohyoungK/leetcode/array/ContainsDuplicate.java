package algorithm.solution.dohyoungK.leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num : nums) {
            int count = hm.getOrDefault(num, 0);

            if (count != 0) {
                return true;
            } else {
                hm.put(num, count + 1);
            }
        }

        return false;
    }
}
