package algorithm.solution.dohyoungK.leetcode.array;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }
}
