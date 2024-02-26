package algorithm.solution.smileDK.leetcode.array;

// Memo.
//  Q. 주어진 정렬된 배열에서 중복 제거 후 남은 요소들의 개수 반환

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int index = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}
