package algorithm.solution.DokyungHwang.programmers.hash;

import algorithm.problem.programmers.hash.P3;

import java.util.HashMap;

public class S3 implements P3 {
    public static void main(String[] args) {
        String[] phone_book1 = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123","456","789"};
        String[] phone_book3 = {"12","123","1235","567","88"};

        System.out.println(solution(phone_book1));
        System.out.println(solution(phone_book2));
        System.out.println(solution(phone_book3));
    }

    public static boolean solution(String[] phone_book) {

        // HashMap 생성
        // key<String> | value<Integer>
        //     119              1
        //  97674223            2
        // 1195524421           3
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            hashMap.put(phone_book[i], i);
        }

        // phone_book 요소가 hashMap에 있는 지 체크
        // 97674223
        // j -> 9 97 976 9756 ...
        for (String s : phone_book) {
            for (int j = 1; j < s.length(); j++) {
                if (hashMap.containsKey(s.substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }
}
