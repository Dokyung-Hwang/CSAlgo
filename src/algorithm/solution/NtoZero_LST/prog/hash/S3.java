package algorithm.solution.NtoZero_LST.prog.hash;

import algorithm.problem.programmers.hash.P3;

import java.util.Arrays;

public class S3 implements P3 {
    /*
        phone_book : 10^6 이하
        phone_num : 20 이하
    */
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++){
            if (phone_book[i + 1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }
}
