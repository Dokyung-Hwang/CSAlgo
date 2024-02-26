package algorithm.solution.smileDK.leetcode.array;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4,5,6,7};
        int[] nums2 = new int[]{-1,-100,3,99};

        rotate(nums1, 3);
        rotate(nums2, 2);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    public static void rotate(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k % nums.length == 0) {
            return;
        }

        int length = nums.length;
        k %= length;

        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
