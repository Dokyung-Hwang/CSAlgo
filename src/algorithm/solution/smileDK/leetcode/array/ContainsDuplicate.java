package algorithm.solution.smileDK.leetcode.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }


    // Memo.
    //  Time Limit Exceeded
//    public static boolean containsDuplicate(int[] nums) {
//        List<Integer> numList =
//                Arrays.stream(nums)
//                .boxed()
//                .collect(Collectors.toList());
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (numList.get(i).equals(numList.get(j))) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public static boolean containsDuplicate(int[] nums) {
        List<Integer> numsList =
                Arrays.stream(nums)
                        .boxed()
                        .distinct()
                        .collect(Collectors.toList());

        if (numsList.size() != nums.length) {
            return true;
        }
        else
            return false;
    }
}
