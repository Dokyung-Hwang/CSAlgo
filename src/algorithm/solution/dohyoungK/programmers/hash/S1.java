package algorithm.solution.dohyoungK.programmers.hash;

import algorithm.problem.programmers.hash.P1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class S1 implements P1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2,3}));
    }

    public static int solution(int[] nums) {
        HashSet<Integer> hs = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));

        return Math.min(nums.length / 2, hs.size()); // 중복이 존재할 때의 최대 종류수 와 중복이 없을 때의 종류수 비교
    }
}
