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

    public static int solution(String numbers) {
        int answer = 0;
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 1; i <= numbers.length(); i++) { // 조합할 숫자의 자릿수
            for (int j = 0; j < numbers.length(); j++) { // 조합을 시작할 숫자의 index
                makeNum(hs, numbers, "", j, new boolean[numbers.length()], i);
            }
        }

        for (int num : hs) {
            if (isPrime(num)) answer++;
        }

        return answer;
    }

    public static void makeNum(HashSet<Integer> totalNums, String numbers, String result, int index, boolean[] visited, int len) {
        StringBuilder sb = new StringBuilder(result);
        visited[index] = true;
        sb.append(numbers.charAt(index));

        if (sb.length() == len) {
            totalNums.add(Integer.valueOf(sb.toString()));
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                makeNum(totalNums, numbers, sb.toString(), i, visited.clone(), len);
            }
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
