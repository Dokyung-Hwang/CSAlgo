package algorithm.solution.smileDK.leetcode.array;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(singleNumber(new int[]{1}));
    }

    public static int singleNumber(int[] nums) {
        int result = 0;

        // Memo. "^" = XOR 논리 연산(ttf/tft/ftt/fff)
        for(int num : nums){
            result = result ^ num;
        }

        return result;
    }
}
