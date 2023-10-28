package algorithm.solution.dohyoungK.programmers.bruteForce;

import algorithm.problem.programmers.bruteForce.P4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S4 implements P4 {
    public static void main(String[] args) {
        System.out.println(solution(10 , 2));
    }

// TODO:
//  테두리 brown과 테두리 안쪽 yellow 격자 수를 입력받아
//  카펫의 가로, 세로 구하기

// TODO:
//  가로 * 세로 = brown + yellow 이므로
//  brown + yellow의 약수 조합을 구해서
//  2 * 가로 + 2 * 세로 - 4 = brown에 해당하는 약수 조합 찾기

    public static int[] solution(int brown, int yellow) {
        int[] answer = {};

        List<List<Integer>> divisors = getDivisor(brown + yellow);
        for (List<Integer> divisor : divisors) {
            if (brown == 2 * divisor.get(0) + 2 * divisor.get(1) - 4) {
                return divisor.stream().mapToInt(e -> e).toArray();
            }
        }

        return answer;
    }

    public static List<List<Integer>> getDivisor(int num) {
        List<List<Integer>> divisors = new ArrayList<>();

        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                List<Integer> divisor = new ArrayList<>();
                divisor.add(num / i);
                divisor.add(i);
                divisors.add(divisor);
            }
        }

        return divisors;
    }
}
