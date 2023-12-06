package algorithm.solution.kimhaming.programmers.bruteForce;

import algorithm.problem.programmers.bruteForce.P3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class S3 implements P3 {
    /**
     * 소수 찾기
     * https://velog.io/@haminggu/프로그래머스Java-완전탐색-소수-찾기
     */
    public static void main(String[] args) {
        String numbers = "011";
        System.out.println(solution(numbers));
    }
        // 정답 후보를 저장하는 HashSet
        static HashSet<Integer> numberSet = new HashSet<>();

        // 소수인지 판별하는 메서드
        public static boolean isPrime(int num) {
            if (num == 0 || num == 1) {
                return false;
            }

            int limit = (int) Math.sqrt(num);

            for (int i = 2; i <= limit; i++) {
                if (num % i == 0) {
                    return false;
                }
            }

            return true;
        }

        // 종이 조각을 조합하여 정답 후보를 생성하는 재귀 메서드
        public static void recursive(String comb, String others) {
            if (!comb.equals("")) { // 비어있지 않다면, 정답 후보에 추가
                numberSet.add(Integer.parseInt(comb));
            }

            // 종이 조각을 조합하는 재귀 메서드 호출
            for (int i = 0; i < others.length(); i++) {
                if (!comb.equals("")) {
                    numberSet.add(Integer.valueOf(comb));
                }

                recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
            }
        }
        // 최종: 주어진 종이 조각으로 만들 수 있는 소수의 개수를 리턴하는 메서드
        public static int solution(String numbers) {
            int count = 0;

            // 종이 조각 조합하여 정답 후보 생성
            recursive("", numbers);

            // 정답 후보들 중 소수를 찾아 개수 세기
            Iterator<Integer> it = numberSet.iterator();

            while(it.hasNext()) {
                int number = it.next();

                if (isPrime(number)) {
                count++;
            }
        }

        return count;
        }
}
