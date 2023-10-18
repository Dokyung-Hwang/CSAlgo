package algorithm.solution.NtoZero_LST.programmers.hash;

import java.util.HashSet;

public class S1 implements algorithm.problem.programmers.hash.P1 {
    public int solution(int[] nums) {
        int max = nums.length / 2;

        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        // 최대값이나 중복 제거한 해시셋 크기 중 작은 것 반환
        return Math.min(max, set.size());
    }
}
