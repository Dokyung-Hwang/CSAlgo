package algorithm.solution.kimhaming.leetcode.array;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        // 입력된 배열의 길이가 0이라면, 중복이 없으므로 그대로 0을 반환
        if (nums.length == 0) {
            return 0;
        }

        // 중복이 제거된 배열의 길이를 저장하는 변수
        int result = 1;

        // 배열을 순회하면서 중복 여부 확인
        for (int i = 1; i < nums.length; i++) {
            // 현재 요소와 이전 요소를 비교하여 중복 여부 확인 (다음 요소를 비교하게 되면, IndexOutOf 에러 남)
            if (nums[i] != nums[i-1]) {
                // 중복이 아니면 중복 제거된 배열에 현재 요소 저장
                nums[result] = nums[i];
                // 중복이 아닌 경우에는 결과 배열의 길이를 늘린다.
                result++;
            }
        }

        // 중복이 제거된 배열의 길이 반환
        return result;
    }
}
