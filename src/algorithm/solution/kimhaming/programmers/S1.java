package algorithm.solution.kimhaming.programmers;

import algorithm.problem.programmers.hash.P1;

import java.util.HashSet;

public class S1 implements P1 {
    // https://velog.io/@haminggu/프로그래머스Java-폰켓몬-HashSet-이용
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3, 4, 5};
        System.out.println(solution(nums));
    }
    public static int solution(int[] nums) {

        int limit = nums.length/2;  // 고를 수 있는 갯수
        HashSet <Integer> set = new HashSet<>();

        for (int ponketmon : nums) {
            set.add(ponketmon); // set 에는 주어진 폰켓몬 종류가 담김 (중복 없이)
        }

        return Math.min(limit, set.size());

        // Math.min() 을 안쓰고 if-else 로 표현하면
//        int answer = 0;
//
//        if (limit > set.size()) {
//            answer = set.size();
//        } else {
//            answer = limit;
//        }
//
//        return answer;
    }
}
