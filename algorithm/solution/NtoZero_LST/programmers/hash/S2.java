package algorithm.solution.NtoZero_LST.programmers.hash;

import java.util.HashMap;

public class S2 implements algorithm.problem.programmers.hash.P2 {
    /*
        N : 10^6
    */
    public String solution(String[] participant, String[] completion) {
        int N = participant.length;
        HashMap<String, Integer> map = new HashMap<>();

        for(String s : participant) {
            map.put(s, map.getOrDefault(s,0)+1); //삼항 연산자를 사용하면 NPE 발생
        }
        for(String s : completion) {
            map.put(s, map.getOrDefault(s,0)-1);
        }

        String answer = "";
        for(String name: map.keySet()) {
            if(map.get(name) != 0) {
                answer = name;
                break;
            }
        }
        return answer;
    }
}
