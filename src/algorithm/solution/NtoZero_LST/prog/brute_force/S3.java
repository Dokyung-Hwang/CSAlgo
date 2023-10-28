package algorithm.solution.NtoZero_LST.prog.brute_force;


import algorithm.problem.programmers.bruteForce.P3;
import java.util.*;


/*
    numbers 길이 1 이상 7 이하인 문자열
    numbers의 조합으로 소수를 몇 개 만들 수 있는지 판별
*/

public class S3 implements P3 {
    public int solution(String numbers) {
        int answer = 0;
        // 문자들의 배열 chars 로 변경
        char[] chars = numbers.toCharArray();
        // chars의 길이만큼 방문했는지 여부 따지기 (숫자 조각 사용 여부)
        boolean[] visited = new boolean[chars.length];
        // 소수집합
        Set<Integer> primeSet = new HashSet<>();

        // 주어진 숫자로 만들 수 있는 순열을 생성하고 소수 여부를 판별
        for (int r = 1; r <= chars.length; r++) {
            permute(chars, visited, 0, r, "", primeSet);
        }

        // 소수 개수 계산
        for (int num : primeSet) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    // 순열 생성 (재귀 함수)
    private void permute(char[] chars, boolean[] visited, int depth, int r, String current, Set<Integer> primeSet) {
        // 깊이가 같아지고 num가 1이상인 경우 num 자체를 primeSet에 추가
        if (depth == r) {
            int num = Integer.parseInt(current);
            if (num > 1) {
                primeSet.add(num);
            }
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // 숫자 조각 사용 여부
            if (!visited[i]) {
                visited[i] = true; //사용
                //주어진 모든 숫자 조합을 사용하기 위해 재귀 활용
                permute(chars, visited, depth + 1, r, current + chars[i], primeSet);
                visited[i] = false; //미사용
            }
        }
    }

    // 소수 판별
    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            // 2이상의 정수가 num의 제곱근과 맞아 떨어지면 소수가 아니다.
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
