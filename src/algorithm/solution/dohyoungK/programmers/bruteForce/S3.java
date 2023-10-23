package algorithm.solution.dohyoungK.programmers.bruteForce;

import algorithm.problem.programmers.bruteForce.P3;

import java.util.HashSet;

public class S3 implements P3 {
    public static void main(String[] args) {
        System.out.println(solution("011"));
    }

// TODO:
//  0 ~ 9 숫자가 적힌 문자열 입력받아
//  각 숫자를 조합해 소수가 몇 개인지 리턴

// TODO:
//  dfs로 문자열의 각 자리의 숫자를 조합해
//  구할 수 있는 모든 숫자를 구하고
//  그 수가 소수인지 판별

    static boolean[] visited;
    static HashSet<Integer> hs = new HashSet<>();

    public static int solution(String numbers) {
        int result = 0;
        visited = new boolean[numbers.length()];
        for (int i = 1; i <= numbers.length(); i++) { // 조합할 숫자의 자릿수
            makeNum(numbers, "", i);
        }

        for (int num : hs) {
            if (isPrime(num)) result++;
        }

        return result;
    }

    public static void makeNum(String numbers, String num, int len) {
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeNum(numbers, num + numbers.charAt(i), len);
                visited[i] = false;
            }
        }

        if (num.length() == len) {
            hs.add(Integer.valueOf(num));
        }
    }

    public static boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
