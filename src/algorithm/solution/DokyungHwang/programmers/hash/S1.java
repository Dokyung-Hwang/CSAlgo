package algorithm.solution.DokyungHwang.programmers.hash;

import algorithm.problem.programmers.hash.P1;

import java.util.HashSet;

public class S1 implements P1 {
    public static void main(String[] args) {
        int[] testcase1 = {3,1,2,3};
        int[] testcase2 = {3,3,3,2,2,4};
        int[] testcase3 = {3,3,3,2,2,2};

        System.out.println(solution(testcase1));
        System.out.println(solution(testcase2));
        System.out.println(solution(testcase3));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int n = nums.length/2;

        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        answer = Math.min(n, hashSet.size());
        return answer;
    }
}

/*
Programmers - Pokemon
제한사항
* nums는 포켓몬의 종류 번호가 담긴 1차원배열(1 <= nums <= 10,000 자연수, 항상 짝수)
* 1<= 포켓몬의 종류 번호 <= 200,000
* 가장 많은 종류의 포켓몬을 선택하는 방법이 여러 가지인 경우 선택할 수 있는 포켓몬 종류 개수의 최댓값 하나만 반환
* */