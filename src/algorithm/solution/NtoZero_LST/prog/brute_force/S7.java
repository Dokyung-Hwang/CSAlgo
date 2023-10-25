package algorithm.solution.NtoZero_LST.prog.brute_force;

import algorithm.problem.programmers.bruteForce.P7;

import java.util.*;
// https://velog.io/@jh5253/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%AA%A8%EC%9D%8C%EC%82%AC%EC%A0%84-Java%EC%9E%90%EB%B0%94
public class S7 implements P7 {
    static List<String> list;
    // 조합할 수 있는 모음 다섯 가지
    static String [] words = {"A", "E", "I", "O", "U"};

    public static void main(String[] args) {
        solution("AAAAE");
    }

    public static int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        //dfs 첫 문자열 ""은 버리는 것
        dfs("", 0);
        int size = list.size();
        // list의 모든 요소를 순회하면서 i 인덱스가 인자로 주어진 word와 일치한다면 멈춤
        for (int i = 0; i < size; i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    static void dfs(String str, int len) {
        //list에 조합된 str 포함하기
        list.add(str);
        if (len == 5) return; // return이 될 때만 i값이 1씩 증가한다.
        for (int i = 0; i < 5; i++) {
            // i는 0일 때 len이 1, 2, 3, 4, 5("AAAAA")
            // i는 1,2,3,4일 때 len이 5(AAAAE), 5(AAAAI), 5(AAAAO), 5(AAAAU) ???
            dfs(str + words[i], len + 1);
        }
    }
}
