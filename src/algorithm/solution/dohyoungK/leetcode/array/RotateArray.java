package algorithm.solution.dohyoungK.leetcode.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        while (k-- > 0) {
            deque.addFirst(deque.pollLast());
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = deque.poll();
        }
    }
}
