package algorithm.solution.dohyoungK.leetcode.topInterview150.arrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;

        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                numList.add(nums[i]);
            }
        }

        for (int i = 0; i < numList.size(); i++) {
            nums[i] = numList.get(i);
        }

        return numList.size();
    }
}