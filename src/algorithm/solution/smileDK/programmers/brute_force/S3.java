package algorithm.solution.smileDK.programmers.brute_force;

import algorithm.problem.programmers.bruteForce.P4;

import java.util.HashSet;
import java.util.Iterator;

public class S3 implements P4 {
    HashSet<Integer> numberSet = new HashSet<>();

    public static void main(String[] args) {
        S3 test1 = new S3();
        System.out.println(test1.solution("17"));

        S3 test2 = new S3();
        System.out.println(test2.solution("011"));
    }

    public void recursive(String comb, String others) {
        // 1. 현재 조합을 Set에 추가
        if (!comb.isEmpty()) {
            numberSet.add(Integer.parseInt(comb));
        }
        // 3. 남은 숫자 중 하나를 더 더해서 새로운 조합을 만든다.
        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i+1));
        }
    }


    // 에라토스테네스의 체
    public boolean isPrime(int num) {
        // 1. (0 or 1 != prime number)
        if (num == 0 || num == 1) return false;

        // 2. 에라토스테네스의 체의 limit 구하기
        int limit = (int) Math.sqrt(num);

        // 3. 에라토스테네스의 체에 따라 limit 까지만 배수의 여부 확인
        for (int i = 2; i <= limit; i++)
            if (num % i == 0)
                return false;

        return true;
    }

    public int solution(String numbers) {
        int count = 0;
        recursive("", numbers);

        Iterator<Integer> iterator = numberSet.iterator();

        while(iterator.hasNext()) {
            int number = iterator.next();
            if (isPrime(number)) {
                count++;
            }
        }

        return count;
    }
}

/*
* 1. 문자열 분리
* 2. 분리된 문자열로 만들 수 있는 경우의 수 전부 구하기
* 3. 모든 경우의 수 중복 검사(Set)
* 4. 만들어진 경우의 수 형변환 (String -> int)
* 5. 모든 경우의 수 소수 인지 검사 후 카운팅
* */
