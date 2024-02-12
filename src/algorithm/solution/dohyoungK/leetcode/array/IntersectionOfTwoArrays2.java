package algorithm.solution.dohyoungK.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArrays2 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};

        System.out.println(intersect(nums1, nums2));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();

        for (int num : nums1) {
            int value = hm1.getOrDefault(num, 0);
            hm1.put(num, value + 1);
        }
        for (int num : nums2) {
            int value = hm2.getOrDefault(num, 0);
            hm2.put(num, value + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int key : hm1.keySet()) {
            int value1 = hm1.get(key);
            int value2 = hm2.getOrDefault(key, 0);

            if (value2 != 0) {
                for (int i = 0; i < Math.min(value1, value2); i++) result.add(key);
            }
        }

        return result.stream().mapToInt(e -> e).toArray();
    }
}
